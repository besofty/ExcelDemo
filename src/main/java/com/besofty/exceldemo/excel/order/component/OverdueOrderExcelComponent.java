package com.besofty.exceldemo.excel.order.component;

import com.besofty.exceldemo.order.enums.OrderStatusEnum;
import com.besofty.exceldemo.excel.order.dto.OverdueOrderExcelDTO;
import com.besofty.exceldemo.util.excel.ExcelUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OverdueOrderExcelComponent extends OrderExcelComponent{

    @Override
    public OrderStatusEnum getCode() {
        return OrderStatusEnum.OVERDUE_ORDER;
    }

    @Override
    public XSSFWorkbook generateExcel(Integer orderStatus) {
        List<OverdueOrderExcelDTO> overdueOrderExcelDTOS = getContent(orderStatus)
                .stream()
                .map(OverdueOrderExcelDTO::fromLoanOrderDO)
                .collect(Collectors.toList());
        return ExcelUtil.generateExcel(OverdueOrderExcelDTO.class, overdueOrderExcelDTOS);
    }
}
