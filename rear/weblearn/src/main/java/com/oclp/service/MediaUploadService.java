package com.oclp.service;

import com.alibaba.fastjson.JSON;
import com.oclp.common.exception.ExceptionCast;
import com.oclp.common.model.response.CommonCode;
import com.oclp.common.model.response.ResponseResult;
import com.oclp.dao.MediaFileRepository;
import com.oclp.domain.media.MediaFile;
import com.oclp.domain.media.response.CheckChunkResult;
import com.oclp.domain.media.response.MediaCode;
import com.oclp.utils.RabbitMQConfig;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.*;

@Service
public class MediaUploadService {
    @Autowired
    MediaFileRepository mediaFileRepository;

    @Value("${weblearn-media.upload-location}")
    String upload_location;
    @Value("${weblearn-media.mq.routingkey-media-video}")
    public  String routingkey_media_video;

    @Autowired
    RabbitTemplate rabbitTemplate;

    //得到文件所属目录路径
    private String getFileFolderPath(String fileMd5){
        return upload_location+fileMd5.substring(0,1)+"/"+fileMd5.substring(1,2)+"/"+fileMd5+"/";
    }
    //得到文件路径
    private String getFilePath(String fileMd5,String fileExt){
        return upload_location+fileMd5.substring(0,1)+"/"+fileMd5.substring(1,2)+"/"+fileMd5+"/"+fileMd5+"."+fileExt;
    }
    //得到块文件所属目录路径
    private String getChunkFileFolderPath(String fileMd5){
        return upload_location+fileMd5.substring(0,1)+"/"+fileMd5.substring(1,2)+"/"+fileMd5+"/chunk/";
    }

    //文件上传的注册，检查文件是否存在
    public ResponseResult register(String fileMd5, String fileName, Long fileSize, String mimetype, String fileExt) {

        String fileFolderPath=this.getFileFolderPath(fileMd5);
        String filePath=this.getFilePath(fileMd5,fileExt);
        File file=new File(filePath);
        //文件是否存在
        boolean exists=file.exists();
        //检查文件信息在mongodb是否存在
        Optional<MediaFile> optional = mediaFileRepository.findById(fileMd5);
        //文件存在直接返回
        if(exists && optional.isPresent()){
            ExceptionCast.cast(MediaCode.UPLOAD_FILE_REGISTER_EXIST);
        }
        //文件不存在时
        File fileFolder=new File(fileFolderPath);
        if (!fileFolder.exists()){
            fileFolder.mkdirs();
        }
        return new ResponseResult(CommonCode.SUCCESS);
    }

    //分块检查
    public CheckChunkResult checkchunk(String fileMd5, Integer chunk, Integer chunkSize) {

        //检查分块文件是否存在
        String chunkFileFolderPath=this.getChunkFileFolderPath(fileMd5);
        //得到块文件
        File chunkFile=new File(chunkFileFolderPath+chunk);
        //块文件是否存在
        if (chunkFile.exists()){
            return new CheckChunkResult(CommonCode.SUCCESS,true);
        }else{
            return new CheckChunkResult(CommonCode.SUCCESS,false);
        }
    }

    //上传分块
    public ResponseResult uploadchunk(MultipartFile file, Integer chunk, String fileMd5) {
        //检查分块目录，不存在则创建
        String chunkFileFolderPath=this.getChunkFileFolderPath(fileMd5);
        String chunkFilePath=chunkFileFolderPath+chunk;
        File chunkFileFolder=new File(chunkFileFolderPath);
        if (!chunkFileFolder.exists()){
            chunkFileFolder.mkdirs();
        }
        //得到上传文件输入流
        InputStream inputStream=null;
        FileOutputStream fileOutputStream=null;
        try {
            inputStream=file.getInputStream();
            fileOutputStream=new FileOutputStream(new File(chunkFilePath));
            IOUtils.copy(inputStream,fileOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ResponseResult(CommonCode.SUCCESS);
    }
    //合并分块
    public ResponseResult mergechunks(String fileMd5, String fileName, Long fileSize, String mimetype, String fileExt) {

        //合并所有分块
        String chunkFileFolderPath=this.getChunkFileFolderPath(fileMd5);
        File chunkFileFolder=new File(chunkFileFolderPath);
        //分块文件列表
        File[] files=chunkFileFolder.listFiles();
        List<File> files1=Arrays.asList(files);
        //创建合并文件
        String filePath=this.getFilePath(fileMd5,fileExt);
        File mergeFile=new File(filePath);
        //执行合并
        mergeFile=this.mergeFile(files1,mergeFile);
        if (mergeFile==null){
            //合并出错
            ExceptionCast.cast(MediaCode.MERGE_FILE_FAIL);
        }
        //检验md5是否一致
        boolean checkFileMd5=this.checkFileMd5(mergeFile,fileMd5);
        if (!checkFileMd5){
            //校验文件失败
            ExceptionCast.cast(MediaCode.MERGE_FILE_CHECKFAIL);
        }
        //将文件信息写入mongodb
        MediaFile mediaFile=new MediaFile();
        mediaFile.setFileId(fileMd5);
        mediaFile.setFileOriginalName(fileName);
        mediaFile.setFileName(fileMd5+"."+fileExt);
        //文件路径保存相对路径
        String filePath1=fileMd5.substring(0,1)+"/"+fileMd5.substring(1,2)+"/"+fileMd5+"/";
        mediaFile.setFilePath(filePath1);
        mediaFile.setFileSize(fileSize);
        mediaFile.setUploadTime(new Date());
        mediaFile.setMimeType(mimetype);
        mediaFile.setFileType(fileExt);
        //状态为上传成功
        mediaFile.setFileStatus("301002");
        mediaFileRepository.save(mediaFile);
        //向MQ发送视频处理消息
        sendProcessVideoMsg(mediaFile.getFileId());
        return new ResponseResult(CommonCode.SUCCESS);
    }
    //发送视频处理消息
    public ResponseResult sendProcessVideoMsg(String mediaId){

        Optional<MediaFile> optional=mediaFileRepository.findById(mediaId);
        if (!optional.isPresent()){
            ExceptionCast.cast(CommonCode.FAIL);
        }
        Map<String,String> map=new HashMap<>();
        map.put("mediaId",mediaId);
        String jsonString= JSON.toJSONString(map);
        try {
            rabbitTemplate.convertAndSend(RabbitMQConfig.EX_MEDIA_PROCESSTASK,routingkey_media_video,jsonString);
        }catch (AmqpException e){
            e.printStackTrace();
            return new ResponseResult(CommonCode.FAIL);
        }
        return new ResponseResult(CommonCode.SUCCESS);
    }
    //合并文件
    private File mergeFile(List<File> chunkFileList,File mergeFile){
        try {
            if (mergeFile.exists()){
                mergeFile.delete();
            }else {
                mergeFile.createNewFile();

            }
            //对块文件排序
            Collections.sort(chunkFileList, new Comparator<File>() {
                @Override
                public int compare(File o1, File o2) {
                    if (Integer.parseInt(o1.getName())>Integer.parseInt(o2.getName())) {
                        return 1;
                    }
                    return -1;
                }
            });
            //创建一个写对象
            RandomAccessFile raf_write=new RandomAccessFile(mergeFile,"rw");
            byte[] b = new byte[1024];
            for (File chunkFile:chunkFileList){
                RandomAccessFile raf_read=new RandomAccessFile(chunkFile,"r");
                int len=-1;
                while ((len=raf_read.read(b))!=-1){
                    raf_write.write(b,0,len);
                }
                raf_read.close();
            }
            raf_write.close();
            return mergeFile;
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
    //校验文件
    private boolean checkFileMd5(File mergeFile,String md5){
        try {
            //创建文件输入流
            FileInputStream inputStream=new FileInputStream(mergeFile);
            //得到文件的md5
            String mergeFileMd5 = DigestUtils.md5Hex(inputStream);
            if (md5.equalsIgnoreCase(mergeFileMd5)){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
