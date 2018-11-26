package io.lvlvforever.night;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by lvlvforever on 2018/11/18.
 */
public class ExcelUtil {

    public static <T> List<T> readExcel (HandleExcel<T> handler) {
        String filePath = handler.getFilePath();
        try(BufferedInputStream ins = new BufferedInputStream(new FileInputStream(filePath));
            Workbook readBook = WorkbookFactory.create(ins)) {
            List<T> list = handler.handle(readBook);
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e2) {
            e2.printStackTrace();

        }
        return null;
    }
}
