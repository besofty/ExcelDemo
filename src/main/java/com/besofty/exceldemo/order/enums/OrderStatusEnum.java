package com.besofty.exceldemo.order.enums;

import java.util.stream.Stream;

public enum OrderStatusEnum {
    /**
     * 订单状态枚举
     */
    APPLY_NOT_PASSED(1, "APPLY_NOT_PASSED"),
    NORMAL_REPAYMENT(2, "NORMAL_REPAYMENT"),
    OVERDUE_ORDER(3, "OVERDUE_ORDER");

    private Integer code;
    private String value;

    OrderStatusEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public static OrderStatusEnum getByValue(String value){
        return Stream.of(OrderStatusEnum.values())
                .filter(statusEnum -> value.equals(statusEnum.getValue()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("不存在的订单类型"));
    }

    public Integer getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
