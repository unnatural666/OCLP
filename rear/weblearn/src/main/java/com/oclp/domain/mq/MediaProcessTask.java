package com.oclp.domain.mq;

import com.alibaba.fastjson.JSON;
import com.oclp.dao.MediaFileRepository;
import com.oclp.domain.media.MediaFile;
import com.oclp.domain.media.MediaFileProcess_m3u8;
import com.oclp.utils.HlsVideoUtil;
import com.oclp.utils.Mp4VideoUtil;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class MediaProcessTask {

    //ffmpeg绝对路径
    @Value("${weblearn-media.ffmpeg-path}")
    String ffmpeg_path;
    //上传文件根目录
    @Value("${weblearn-media.upload-location}")
    String serverPath;

    @Autowired
    MediaFileRepository mediaFileRepository;

    //接收视频处理消息进行视频处理
    @RabbitListener(queues = "${weblearn-media.mq.queue-media-video-processor}",containerFactory="customContainerFactory")
    public void receiveMediaProcessTask(String msg){
        Map msgMap = JSON.parseObject(msg, Map.class);
        String mediaId= (String) msgMap.get("mediaId");
        Optional<MediaFile> optional=mediaFileRepository.findById(mediaId);
        if (!optional.isPresent()){
            return;
        }
        MediaFile  mediaFile=optional.get();
        String fileType=mediaFile.getFileType();
        if (!fileType.equals("avi")){
            mediaFile.setProcessStatus("303004");//无需处理
            mediaFileRepository.save(mediaFile);
        }else {
            //需要处理
            mediaFile.setProcessStatus("303001");
            mediaFileRepository.save(mediaFile);
        }

        String video_path=serverPath+mediaFile.getFilePath()+mediaFile.getFileName();
        String mp4_name=mediaFile.getFileId()+".mp4";
        String mp4folder_path=serverPath+mediaFile.getFilePath();
        Mp4VideoUtil mp4VideoUtil=new Mp4VideoUtil(ffmpeg_path,video_path,mp4_name,mp4folder_path);
        String result=mp4VideoUtil.generateMp4();
        if (result==null||!result.equals("success")){
            //处理失败
            mediaFile.setProcessStatus("303003");
            MediaFileProcess_m3u8 mediaFileProcess_m3u8=new MediaFileProcess_m3u8();
            mediaFileProcess_m3u8.setErrormsg(result);
            mediaFile.setMediaFileProcess_m3u8(mediaFileProcess_m3u8);//记录失败原因
            mediaFileRepository.save(mediaFile);
            return;
        }
        String mp4_video_path=serverPath+mediaFile.getFilePath()+mp4_name;
        String m3u8_name=mediaFile.getFileId()+".m3u8";
        String m3u8folder_path=serverPath+mediaFile.getFilePath()+"hls/";
        HlsVideoUtil hlsVideoUtil=new HlsVideoUtil(ffmpeg_path,mp4_video_path,m3u8_name,m3u8folder_path);
        //生成m3u8和ts文件
        String tsResult=hlsVideoUtil.generateM3u8();
        if (tsResult==null||!tsResult.equals("success")){
            //处理失败
            mediaFile.setProcessStatus("303003");
            MediaFileProcess_m3u8 mediaFileProcess_m3u8=new MediaFileProcess_m3u8();
            mediaFileProcess_m3u8.setErrormsg(result);
            mediaFile.setMediaFileProcess_m3u8(mediaFileProcess_m3u8);//记录失败原因
            mediaFileRepository.save(mediaFile);
            return;
        }
        //处理成功
        List<String> ts_list=hlsVideoUtil.get_ts_list();
        mediaFile.setProcessStatus("303002");
        MediaFileProcess_m3u8 mediaFileProcess_m3u8=new MediaFileProcess_m3u8();
        mediaFileProcess_m3u8.setTslist(ts_list);
        mediaFile.setMediaFileProcess_m3u8(mediaFileProcess_m3u8);

        String fileUrl=mediaFile.getFilePath()+"hls/"+m3u8_name;
        mediaFile.setFileUrl(fileUrl);
        mediaFileRepository.save(mediaFile);

    }
}
