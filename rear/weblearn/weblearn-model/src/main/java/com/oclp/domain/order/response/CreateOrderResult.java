package com.oclp.domain.order.response;

import com.oclp.domain.order.XcOrders;
import com.oclp.model.response.ResponseResult;
import com.oclp.model.response.ResultCode;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class CreateOrderResult extends ResponseResult {
    private XcOrders xcOrders;
    public CreateOrderResult(ResultCode resultCode, XcOrders xcOrders) {
        super(resultCode);
        this.xcOrders = xcOrders;
    }


}
