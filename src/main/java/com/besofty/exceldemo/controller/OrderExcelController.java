package com.besofty.exceldemo.controller;

import com.besofty.exceldemo.excel.order.OrderExcelService;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/api/excel")
public class OrderExcelController {
    @Autowired
    private OrderExcelService orderExcelService;

    @ApiOperation(value = "导出订单excel", nickname = "exportOrderExcel", httpMethod = "POST", notes = "导出订单excel")
    @PostMapping("/orders")
    public void exportOrderExcel(HttpServletResponse response,
                                     String excelTypeCode) throws IOException {
        XSSFWorkbook workbook = orderExcelService.getWorkbook(excelTypeCode);
        response.setHeader("content-Type", "application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=xxx.xlsx");
        workbook.write(response.getOutputStream());
        workbook.close();
    }
}
