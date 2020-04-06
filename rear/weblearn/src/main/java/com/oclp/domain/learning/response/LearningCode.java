package com.oclp.domain.learning.response;

import com.oclp.common.model.response.ResultCode;
import lombok.ToString;

@ToString
public enum LearningCode implements ResultCode {

    LEARNING_GETMEDIA_ERROR(false,23001,"获取学习地址失败！");
    //操作代码
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;

    LearningCode(boolean success, int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }

    @Override
    public boolean success() {
        return false;
    }

    @Override
    public int code() {
        return 0;
    }

    @Override
    public String message() {
        return null;
    }
}
