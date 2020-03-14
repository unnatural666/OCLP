package com.oclp.domain.order.response;

import com.oclp.model.response.ResponseResult;
import com.oclp.model.response.ResultCode;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class PayQrcodeResult extends ResponseResult {
    public PayQrcodeResult(ResultCode resultCode){
        super(resultCode);
    }
    private String codeUrl;
    private Float money;
    private String orderNumber;

}
