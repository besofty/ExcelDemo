package com.besofty.exceldemo.order.excel.dto;

import com.besofty.exceldemo.order.domain.OrderDO;
import com.besofty.exceldemo.util.excel.ExcelResources;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class NormalRepaymentExcelDTO extends BaseOrderDTO{
    @ExcelResources(title = "打款时间", order = 4, fieldName = "giveTime")
    private Date giveTime;
    @ExcelResources(title = "还款时间", order = 5, fieldName = "limitPayTime")
    private Date limitPayTime;

    public static NormalRepaymentExcelDTO fromLoanOrderDO(OrderDO loanOrderDO){
        NormalRepaymentExcelDTO normalRepaymentExcelDTO= new NormalRepaymentExcelDTO();
        normalRepaymentExcelDTO.setGiveTime(loanOrderDO.getGiveTime());
        normalRepaymentExcelDTO.setLimitPayTime(loanOrderDO.getLimitPayTime());
        normalRepaymentExcelDTO.setOrderNumber(loanOrderDO.getOrderNumber());
        normalRepaymentExcelDTO.setUserName(loanOrderDO.getUserName());
        normalRepaymentExcelDTO.setAmount(loanOrderDO.getAmount());
        return normalRepaymentExcelDTO;
    }
}
