package com.besofty.exceldemo.excel.order.component;

import com.besofty.exceldemo.order.OrderService;
import com.besofty.exceldemo.order.domain.OrderDO;
import com.besofty.exceldemo.order.enums.OrderStatusEnum;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public abstract class OrderExcelComponent {
    @Autowired
    private OrderService orderService;

    /**
     * 获取excel的code
     */
    public abstract OrderStatusEnum getCode();

    public abstract XSSFWorkbook generateExcel(Integer orderStatus);

    /**
     * 获取excel订单内容
     */
    protected List<OrderDO> getContent(Integer orderStatus){
        return orderService.getOrders(orderStatus);
    }

}
