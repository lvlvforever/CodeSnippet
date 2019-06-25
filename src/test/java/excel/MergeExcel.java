/**
 * Description:
 * User: daipeng
 * Date: 2019-05-05 16:30
 * Project:CodeSnippet
 */
package excel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

public class MergeExcel {
    public static void main(String[] args) throws Exception{
        String filePath = "e:/test.xlsx";
        Workbook book = new XSSFWorkbook();

        // 写数据到excel
        Sheet sheet = book.createSheet("poi测试demo");


        Map<Long, Map<String, String>> list = new HashMap<>();

        Map<String, String> a = new HashMap<>();
        a.put("10001", "第一本书");
        Map<String, String> b = new HashMap<>();
        b.put("10002", "第2本书");

        list.put(1L, a);
        list.put(2L, b);





        Row firstRow = sheet.createRow(0);
        Row  secondRow = sheet.createRow(1);
        Row thirdRow = sheet.createRow(2);

        firstRow.createCell(0).setCellValue("日期");
        firstRow.createCell(1).setCellValue("平台");
        secondRow.createCell(0);
        secondRow.createCell(1);
        thirdRow.createCell(0);
        thirdRow.createCell(1);
        CellRangeAddress cra = new CellRangeAddress(0, 2, 0, 0); // 起始行, 终止行, 起始列, 终止列
        sheet.addMergedRegion(cra);

        cra = new CellRangeAddress(0, 2, 1, 1); // 起始行, 终止行, 起始列, 终止列
        sheet.addMergedRegion(cra);



        int bookGroupIndex = 1;
        for (Map.Entry<Long, Map<String, String>> bookGroup : list.entrySet()) {
            Map<String, String> value = bookGroup.getValue();
            Long bookGroupId = bookGroup.getKey();

            for (Map.Entry<String, String> entry : value.entrySet()) {
                String bid = entry.getKey();
                String name = entry.getValue();
                Short lastNum = thirdRow.getLastCellNum();
                thirdRow.createCell(lastNum).setCellValue("书封点击PV");
                thirdRow.createCell(lastNum+1).setCellValue("书封点击UV");
                thirdRow.createCell(lastNum+2).setCellValue("阅读点击PV");
                thirdRow.createCell(lastNum+3).setCellValue("阅读点击UV");
                thirdRow.createCell(lastNum+4).setCellValue("加书架点击PV");
                thirdRow.createCell(lastNum+5).setCellValue("加书架点击UV");
                secondRow.createCell(lastNum).setCellValue(name + "(" + bid + ")");
                secondRow.createCell(lastNum + 1);
                secondRow.createCell(lastNum + 2);
                secondRow.createCell(lastNum + 3);
                secondRow.createCell(lastNum + 4);
                secondRow.createCell(lastNum + 5);

                firstRow.createCell(lastNum).setCellValue("书组" + bookGroupIndex);
                firstRow.createCell(lastNum+1).setCellValue("书组" + bookGroupIndex);
                firstRow.createCell(lastNum+2).setCellValue("书组" + bookGroupIndex);
                firstRow.createCell(lastNum+3).setCellValue("书组" + bookGroupIndex);
                firstRow.createCell(lastNum+4).setCellValue("书组" + bookGroupIndex);
                firstRow.createCell(lastNum+5).setCellValue("书组" + bookGroupIndex);


                CellRangeAddress bidAndName = new CellRangeAddress(1, 1, lastNum, lastNum+5); // 起始行, 终止行, 起始列, 终止列
                sheet.addMergedRegion(bidAndName);
                bookGroupIndex++;
            }
            int bookNumInBookGroup = value.size();
            int lastNum = firstRow.getLastCellNum();
            int bookGroupFinalCol = lastNum - 6;
//            firstRow.createCell(lastNum).setCellValue("书组" + bookGroupIndex);
            CellRangeAddress bidAndName = new CellRangeAddress(0, 0, bookGroupFinalCol, lastNum-1); // 起始行, 终止行, 起始列, 终止列
            sheet.addMergedRegion(bidAndName);
        }

        FileOutputStream fos = new FileOutputStream(filePath);
        book.write(fos);
        book.close();
        fos.close();
    }
}
