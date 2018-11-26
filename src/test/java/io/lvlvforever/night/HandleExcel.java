package io.lvlvforever.night;

import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;

/**
 * Created by lvlvforever on 2018/11/18.
 */
public interface  HandleExcel<T> {
    List<T> handle(Workbook workbook);

    String getFilePath();
}
