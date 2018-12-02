package com.besofty.exceldemo.order.excel;

import com.besofty.exceldemo.order.enums.OrderStatusEnum;
import com.besofty.exceldemo.order.excel.component.OrderExcelComponent;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderExcelService {
    @Autowired
    private List<OrderExcelComponent> orderExcelComponents;

    public XSSFWorkbook getWorkbook(String excelTypeCode){
        OrderExcelComponent orderExcelComponent = getLoanOrderExcelComponent(excelTypeCode);
        Integer orderStatus = OrderStatusEnum.getByValue(excelTypeCode).getCode();
        return orderExcelComponent.generateExcel(orderStatus);
    }

    private OrderExcelComponent getLoanOrderExcelComponent(String excelTypeCode) {
        return orderExcelComponents
                .stream()
                .filter(component -> OrderStatusEnum.getByValue(excelTypeCode).equals(component.getCode()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("不存在的Excel类型"));
    }
}
