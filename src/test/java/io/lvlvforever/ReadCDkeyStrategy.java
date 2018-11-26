package io.lvlvforever;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lvlvforever on 2018/11/18.
 */
public class ReadCDkeyStrategy implements HandleExcel<String> {

    private int start;
    private int end;
    private String filePath;
    public ReadCDkeyStrategy(String filePath,int start, int end) {
        this.start = start;
        this.end = end;
        this.filePath = filePath;
    }

    @Override
    public String getFilePath() {
        return filePath;
    }

    @Override
    public List<String> handle(Workbook workbook) {

        List<String> keys = new ArrayList<>();
        Sheet sheet = workbook.getSheetAt(0);
        for (int i = start; i < end; i++) {
            keys.add(sheet.getRow(i).getCell(0).getStringCellValue());
        }
        return keys;
    }
}
