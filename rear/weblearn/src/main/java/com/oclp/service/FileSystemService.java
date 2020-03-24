package com.oclp.service;

import com.alibaba.fastjson.JSON;
import com.oclp.common.exception.ExceptionCast;
import com.oclp.common.model.response.CommonCode;
import com.oclp.dao.FileSystemRepository;
import com.oclp.domain.filesystem.FileSystem;
import com.oclp.domain.filesystem.response.FileSystemCode;
import com.oclp.domain.filesystem.response.UploadFileResult;
import org.apache.commons.lang3.StringUtils;
import org.csource.fastdfs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
public class FileSystemService {

    @Value("${weblearn.fastdfs.tracker_servers}")
    String tracker_servers;
    @Value("${weblearn.fastdfs.connect_timeout_in_seconds}")
    int connect_timeout_in_seconds;
    @Value("${weblearn.fastdfs.network_timeout_in_seconds}")
    int network_timeout_in_seconds;
    @Value("${weblearn.fastdfs.charset}")
    String charset;

    @Autowired
    FileSystemRepository fileSystemRepository;

    //上传文件
    public UploadFileResult upload(MultipartFile multipartFile,
                                   String filetag,
                                   String businesskey,
                                   String metadata){
        if (multipartFile==null){
            ExceptionCast.cast(FileSystemCode.FS_UPLOADFILE_FILEISNULL);
        }
        //1.将文件上传到fastDFS中
        String fileId=fdfs_upload(multipartFile);
        if (StringUtils.isEmpty(fileId)){
            ExceptionCast.cast(FileSystemCode.FS_UPLOADFILE_SERVERFAIL);
        }
        //2.将文件id保存到mongodb
        FileSystem fileSystem=new FileSystem();
        fileSystem.setFileId(fileId);
        fileSystem.setFilePath(fileId);
        fileSystem.setFiletag(filetag);
        fileSystem.setBusinesskey(businesskey);
        fileSystem.setFileName(multipartFile.getOriginalFilename());
        fileSystem.setFileType(multipartFile.getContentType());
        if(StringUtils.isNotEmpty(metadata)){
            try {
                Map map = JSON.parseObject(metadata, Map.class);
                fileSystem.setMetadata(map);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        fileSystemRepository.save(fileSystem);
        return new UploadFileResult(CommonCode.SUCCESS,fileSystem);


    }

    //上传文件到fastDFS
    private String fdfs_upload(MultipartFile multipartFile){
        //fastDFS环境
        initFdfs();
        //创建trackerClient
        TrackerClient trackerClient=new TrackerClient();
        try {
            TrackerServer trackerServer=trackerClient.getConnection();
            //得到storage
            StorageServer storageServer=trackerClient.getStoreStorage(trackerServer);
            //创建storageClient来上传文件
            StorageClient1 storageClient1=new StorageClient1(trackerServer,storageServer);
            //上传文件
            byte[] bytes=multipartFile.getBytes();
            //得到文件原始名称
            String originalFilename=multipartFile.getOriginalFilename();
            //得到文件扩展名
            String ext=originalFilename.substring(originalFilename.lastIndexOf(".")+1);
            String fileId=storageClient1.upload_file1(bytes,ext,null);
            return fileId;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    //初始化fastDFS环境
    private void initFdfs(){
        try {
            ClientGlobal.initByTrackers(tracker_servers);
            ClientGlobal.setG_charset(charset);
            ClientGlobal.setG_network_timeout(network_timeout_in_seconds);
            ClientGlobal.setG_connect_timeout(connect_timeout_in_seconds);
        } catch (Exception e) {
            e.printStackTrace();
            //抛异常
            ExceptionCast.cast(FileSystemCode.FS_INITFDFSERROR);
        }
    }
}
