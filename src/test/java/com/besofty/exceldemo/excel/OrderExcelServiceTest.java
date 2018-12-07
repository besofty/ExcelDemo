package com.besofty.exceldemo.excel;

import com.besofty.exceldemo.excel.order.OrderExcelService;
import com.besofty.exceldemo.order.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({})
public class OrderExcelServiceTest {
    @InjectMocks
    private OrderExcelService orderExcelService;
    @Mock
    private OrderService orderService;

    @Test
    public void ApplyNotPassOrderExcelTest(){

    }

}
