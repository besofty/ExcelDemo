package com.besofty.exceldemo.excel.order.component;

import com.besofty.exceldemo.order.enums.OrderStatusEnum;
import com.besofty.exceldemo.excel.order.dto.ApplyNotPassedExcelDTO;
import com.besofty.exceldemo.util.excel.ExcelUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ApplyNotPassedOrderExcelComponent extends OrderExcelComponent{

    @Override
    public OrderStatusEnum getCode() {
        return OrderStatusEnum.APPLY_NOT_PASSED;
    }

    @Override
    public XSSFWorkbook generateExcel(Integer orderStatus) {
        List<ApplyNotPassedExcelDTO> applyNotPassedExcelDTOS = getContent(orderStatus)
                .stream()
                .map(ApplyNotPassedExcelDTO::fromOrderDO)
                .collect(Collectors.toList());
        return ExcelUtil.generateExcel(ApplyNotPassedExcelDTO.class, applyNotPassedExcelDTOS);
    }

}
