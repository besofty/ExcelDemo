package com.besofty.exceldemo.excel.order.dto;

import com.besofty.exceldemo.util.excel.ExcelResources;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public abstract class BaseOrderDTO {
    @ExcelResources(title = "贷款单号", order = 1, fieldName = "orderNumber")
    private String orderNumber;
    @ExcelResources(title = "姓名", order = 2, fieldName = "userName")
    private String userName;
    @ExcelResources(title = "金额", order = 3, fieldName = "realMoney")
    private String amount;
}
