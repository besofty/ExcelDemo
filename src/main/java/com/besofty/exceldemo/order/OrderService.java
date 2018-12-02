package com.besofty.exceldemo.order;

import com.besofty.exceldemo.order.domain.OrderDO;
import com.besofty.exceldemo.order.enums.OrderStatusEnum;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private static List<OrderDO> orders = new ArrayList<>();

    static {
        orders.add(new OrderDO()
                .setAmount("1")
                .setOrderNumber("1")
                .setOrderStatus(OrderStatusEnum.APPLY_NOT_PASSED.getCode())
                .setUserName("1")
                .setRefusedReason("amount < 2"));
        orders.add(new OrderDO()
                .setAmount("2")
                .setOrderNumber("2")
                .setOrderStatus(OrderStatusEnum.NORMAL_REPAYMENT.getCode())
                .setUserName("2")
                .setGiveTime(new Date(1541148277))
                .setLimitPayTime(new Date(1541493877)));
        orders.add(new OrderDO()
                .setAmount("3")
                .setOrderNumber("3")
                .setOrderStatus(OrderStatusEnum.OVERDUE_ORDER.getCode())
                .setUserName("3")
                .setGiveTime(new Date(1541148277))
                .setLimitPayTime(new Date(1541493877))
                .setOverdueDays("3"));
    }

    public List<OrderDO> getOrders(Integer orderStatus){
        return orders.stream()
                .filter(order -> order.getOrderStatus().equals(orderStatus))
                .collect(Collectors.toList());
    }
}
