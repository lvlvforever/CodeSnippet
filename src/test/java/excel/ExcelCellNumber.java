/**
 * Description:
 * User: daipeng
 * Date: 2019-05-05 14:28
 * Project:CodeSnippet
 */
package excel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelCellNumber {
    public static void main(String[] args) throws Exception {
        String filePath = "f:\\专题10000090书组模块.xlsx";

        BufferedInputStream ins = new BufferedInputStream(new FileInputStream(filePath));

        Workbook readBook = WorkbookFactory.create(ins);
//从excel读数据
        Sheet sheet = readBook.getSheetAt(0);
        Row row = sheet.getRow(0);


        int lastCol = row.getPhysicalNumberOfCells();


        System.err.println(lastCol);
        System.err.println(row.getLastCellNum());


        Row sec = sheet.getRow(1);
        System.err.println(sec.getLastCellNum());
        System.err.println(sec.getPhysicalNumberOfCells());



        readBook.close();

    }
}
