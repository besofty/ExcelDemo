package com.besofty.exceldemo.excel.order.component;

import com.besofty.exceldemo.order.enums.OrderStatusEnum;
import com.besofty.exceldemo.excel.order.dto.NormalRepaymentExcelDTO;
import com.besofty.exceldemo.util.excel.ExcelUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class NormalRepaymentExcelComponent extends OrderExcelComponent{

    @Override
    public OrderStatusEnum getCode() {
        return OrderStatusEnum.NORMAL_REPAYMENT;
    }

    @Override
    public XSSFWorkbook generateExcel(Integer orderStatus) {
        List<NormalRepaymentExcelDTO> normalRepaymentExcelDTOS = getContent(orderStatus)
                .stream()
                .map(NormalRepaymentExcelDTO::fromLoanOrderDO)
                .collect(Collectors.toList());
        return ExcelUtil.generateExcel(NormalRepaymentExcelDTO.class, normalRepaymentExcelDTOS);
    }
}
