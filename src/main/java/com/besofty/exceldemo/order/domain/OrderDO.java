package com.besofty.exceldemo.order.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class OrderDO {
    private String id;
    private String orderNumber;
    private String overdueDays;
    private String userName;
    private String amount;
    private Date giveTime;
    private Date limitPayTime;
    private String refusedReason;
    private Integer orderStatus;
}
