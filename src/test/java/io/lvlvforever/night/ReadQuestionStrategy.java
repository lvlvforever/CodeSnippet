package io.lvlvforever.night;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lvlvforever on 2018/11/18.
 */
public class ReadQuestionStrategy implements HandleExcel<Question> {

    private String filePath;

    public ReadQuestionStrategy(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String getFilePath() {
        return filePath;
    }

    @Override
    public List<Question> handle(Workbook workbook) {
        Sheet sheet = workbook.getSheetAt(0);
        Integer rowNumbers = sheet.getLastRowNum();
        List<Question> questions = new ArrayList<>();
        for (int i = 1; i <= rowNumbers; i++) {
            Row row = sheet.getRow(i);
            String name = getCellValue(row,0);
            String optionA = getCellValue(row,1);
            String optionB = getCellValue(row,2);
            String optionC = getCellValue(row,3);
            String optionD = getCellValue(row,4);
            String answer = getCellValue(row,5);
            String episode = getCellValue(row,6);
            List<String> options = Arrays.asList(optionA, optionB, optionC, optionD);
            Integer correctAnswer = parseAnswer(answer);
            String cid = getCellValue(row,7);
            String bid = getCellValue(row,8);

            Question question = null;
            if (cid == null || cid.trim().isEmpty()) {
                //video
                question = new Question(name, options,correctAnswer, episode);
            }else {
                //book
                question = new Question(name, options, correctAnswer, bid, cid, episode);
            }
            questions.add(question);

        }
        return questions;
    }

    private Integer parseAnswer(String correct) {
        if (correct == null || correct.length() != 1) {
            return -1;
        }
        return correct.charAt(0) - '@';
    }

    private String getCellValue(Row row,int index) {
        String value = "";
        Cell cell = row.getCell(index);
        if (cell != null) {
            switch (cell.getCellTypeEnum()) {
                case NUMERIC:
                    value = String.valueOf((int)cell.getNumericCellValue());
                    break;
                case STRING:
                    value = cell.getStringCellValue();
                    break;
            }
        }
        value = value.trim();
        return value;



    }
}
