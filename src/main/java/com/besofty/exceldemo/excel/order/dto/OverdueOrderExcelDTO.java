package com.besofty.exceldemo.excel.order.dto;

import com.besofty.exceldemo.order.domain.OrderDO;
import com.besofty.exceldemo.util.excel.ExcelResources;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class OverdueOrderExcelDTO extends BaseOrderDTO{
    @ExcelResources(title = "逾期天数", order = 4, fieldName = "overdueDays")
    private String overdueDays;
    @ExcelResources(title = "打款时间", order = 5, fieldName = "giveTime")
    private Date giveTime;
    @ExcelResources(title = "应还款时间", order = 6, fieldName = "limitPayTime")
    private Date limitPayTime;

    public static OverdueOrderExcelDTO fromLoanOrderDO(OrderDO loanOrderDO){
        OverdueOrderExcelDTO overdueOrderExcelDTO= new OverdueOrderExcelDTO();
        overdueOrderExcelDTO.setOverdueDays(loanOrderDO.getOverdueDays());
        overdueOrderExcelDTO.setGiveTime(loanOrderDO.getGiveTime());
        overdueOrderExcelDTO.setLimitPayTime(loanOrderDO.getLimitPayTime());
        overdueOrderExcelDTO.setOrderNumber(loanOrderDO.getOrderNumber());
        overdueOrderExcelDTO.setUserName(loanOrderDO.getUserName());
        overdueOrderExcelDTO.setAmount(loanOrderDO.getAmount());
        return overdueOrderExcelDTO;
    }
}
