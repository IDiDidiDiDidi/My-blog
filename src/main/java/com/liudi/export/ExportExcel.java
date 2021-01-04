package com.liudi.export;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author liudi
 * @version 2020/12/24 上午11:37
 */
@Component
public class ExportExcel {

    public void testExportExcel() throws IOException {
        // 创建新的Excel 工作簿
        XSSFWorkbook workbook = new XSSFWorkbook();

        // 在Excel工作簿中建一工作表，其名为缺省值, 也可以指定Sheet名称
        XSSFSheet sheet = workbook.createSheet();
        //HSSFSheet sheet = workbook.createSheet("SheetName");

        // 用于格式化单元格的数据
        XSSFDataFormat format = workbook.createDataFormat();

        // 创建新行(row),并将单元格(cell)放入其中. 行号从0开始计算.
        XSSFRow row = sheet.createRow((short) 1);


        // 设置字体
        XSSFFont font = workbook.createFont();
        font.setFontHeightInPoints((short) 20); //字体高度
        font.setColor(HSSFFont.COLOR_RED); //字体颜色
        font.setFontName("黑体"); //字体
//        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); //宽度
        font.setItalic(true); //是否使用斜体
//        font.setStrikeout(true); //是否使用划线

        // 设置单元格类型
        XSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFont(font);
//        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); //水平布局：居中
        cellStyle.setWrapText(true);

        // 创建单元格
        XSSFCell cell = row.createCell((short) 1);
        XSSFRichTextString hssfString = new XSSFRichTextString("Hello World!");
//        HSSFRichTextString hssfString = new HSSFRichTextString("Hello World!");
        cell.setCellValue(hssfString);//设置单元格内容
        cell.setCellStyle(cellStyle);//设置单元格样式
//        cell.setCellType(XSSFCell.CELL_TYPE_STRING);//指定单元格格式：数值、公式或字符串
//        cell.setCellComment(comment);//添加注释

        //格式化数据
        row = sheet.createRow((short) 2);
        cell = row.createCell((short) 2);
        cell.setCellValue(11111.25);
        cellStyle = workbook.createCellStyle();
        cellStyle.setDataFormat(format.getFormat("0.0"));
        cell.setCellStyle(cellStyle);

        row = sheet.createRow((short) 3);
        cell = row.createCell((short) 3);
        cell.setCellValue(9736279.073);
        cellStyle = workbook.createCellStyle();
        cellStyle.setDataFormat(format.getFormat("#,##0.0000"));
        cell.setCellStyle(cellStyle);


        sheet.autoSizeColumn((short)0); //调整第一列宽度
        sheet.autoSizeColumn((short)1); //调整第二列宽度
        sheet.autoSizeColumn((short)2); //调整第三列宽度
        sheet.autoSizeColumn((short)3); //调整第四列宽度

        workbook.write(new FileOutputStream("/home/liudi/Downloads/export/mlcc-api/aaaaaa.xlsx"));
    }
}
