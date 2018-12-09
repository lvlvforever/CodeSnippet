package io.lvlvforever.night;

import java.util.List;

/**
 * Created by lvlvforever on 2018/11/18.
 */
public class PushData {


    public static void main(String[] args) throws Exception {






        String cdkey = "d:\\night\\1.xlsx";

        ReadCDkeyStrategy cdkeyHandler = new ReadCDkeyStrategy(cdkey, 0, 30000);
        List<String> list = ExcelUtil.readExcel(cdkeyHandler);
        //list.forEach(k -> System.err.println(k));

        String quesionPath = "d:\\night\\将夜答题抽奖活动题库第一周.xls";

        ReadQuestionStrategy readQuestionStrategy = new ReadQuestionStrategy(quesionPath);
        List<Question> questions = ExcelUtil.readExcel(readQuestionStrategy);
        questions.forEach(k -> System.err.println(k));


    }
}
