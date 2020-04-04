package com.oclp.service;

import com.oclp.common.model.response.CommonCode;
import com.oclp.common.model.response.QueryResponseResult;
import com.oclp.common.model.response.QueryResult;
import com.oclp.dao.MediaFileRepository;
import com.oclp.domain.media.MediaFile;
import com.oclp.domain.media.request.QueryMediaFileRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediaFileService {

    @Autowired
    MediaFileRepository mediaFileRepository;

    //查询视频列表
    public QueryResponseResult<MediaFile> findList(int page, int size, QueryMediaFileRequest queryMediaFileRequest) {
        if (queryMediaFileRequest==null){
            queryMediaFileRequest=new QueryMediaFileRequest();
        }
        MediaFile mediaFile=new MediaFile();
        if (StringUtils.isNotEmpty(queryMediaFileRequest.getTag())){
            mediaFile.setTag(queryMediaFileRequest.getTag());
        }
        if (StringUtils.isNotEmpty(queryMediaFileRequest.getFileOriginalName())){
            mediaFile.setFileOriginalName(queryMediaFileRequest.getFileOriginalName());
        }
        if (StringUtils.isNotEmpty(queryMediaFileRequest.getProcessStatus())){
            mediaFile.setProcessStatus(queryMediaFileRequest.getProcessStatus());
        }
        //条件匹配器
        ExampleMatcher exampleMatcher=ExampleMatcher.matching()
                                                        .withMatcher("tag",ExampleMatcher.GenericPropertyMatchers.contains())
                                                        .withMatcher("fileOriginalName",ExampleMatcher.GenericPropertyMatchers.contains());
        //定义example条件对象
        Example<MediaFile> example=Example.of(mediaFile,exampleMatcher);
        //分页查询对象
        if (page<=0){
            page=1;
        }
        page=page-1;
        if (size<=0){
            size=10;
        }
        Pageable pageable = PageRequest.of(page,size);
        Page<MediaFile> all=mediaFileRepository.findAll(example,pageable);
        long total=all.getTotalElements();
        //数据列表
        List<MediaFile> content=all.getContent();
        //返回数据集
        QueryResult<MediaFile> queryResult=new QueryResult<>();
        queryResult.setList(content);
        queryResult.setTotal(total);

        QueryResponseResult queryResponseResult=new QueryResponseResult(CommonCode.SUCCESS,queryResult);
        return queryResponseResult;
    }
}
