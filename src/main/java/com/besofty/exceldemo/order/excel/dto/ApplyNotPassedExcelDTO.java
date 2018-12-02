package com.besofty.exceldemo.order.excel.dto;

import com.besofty.exceldemo.order.domain.OrderDO;
import com.besofty.exceldemo.util.excel.ExcelResources;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ApplyNotPassedExcelDTO extends BaseOrderDTO{
    @ExcelResources(title = "拒绝理由", order = 4, fieldName = "refusedReason")
    private String refusedReason;

    public static ApplyNotPassedExcelDTO fromOrderDO(OrderDO orderDO){
        ApplyNotPassedExcelDTO applyNotPassedExcelDTO= new ApplyNotPassedExcelDTO();
        applyNotPassedExcelDTO.setRefusedReason(orderDO.getRefusedReason());
        applyNotPassedExcelDTO.setOrderNumber(orderDO.getOrderNumber());
        applyNotPassedExcelDTO.setUserName(orderDO.getUserName());
        applyNotPassedExcelDTO.setAmount(orderDO.getAmount());
        return applyNotPassedExcelDTO;
    }
}
