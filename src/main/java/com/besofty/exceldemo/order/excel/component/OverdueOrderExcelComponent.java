package com.besofty.exceldemo.order.excel.component;

import com.besofty.exceldemo.order.enums.OrderStatusEnum;
import com.besofty.exceldemo.order.excel.dto.OverdueOrderExcelDTO;
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
    public XSSFWorkbook generateExcel(String excelTypeCode) {
        List<OverdueOrderExcelDTO> overdueOrderExcelDTOS = getContent(excelTypeCode)
                .stream()
                .map(OverdueOrderExcelDTO::fromLoanOrderDO)
                .collect(Collectors.toList());
        return ExcelUtil.generateExcel(OverdueOrderExcelDTO.class, overdueOrderExcelDTOS);
    }
}
