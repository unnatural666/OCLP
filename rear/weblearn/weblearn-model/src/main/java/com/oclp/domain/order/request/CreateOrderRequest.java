package com.oclp.domain.order.request;

import com.oclp.model.request.RequestData;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CreateOrderRequest extends RequestData {

    String courseId;

}
