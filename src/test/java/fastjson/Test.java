/**
 * Description:
 * User: daipeng
 * Date: 2019-02-01 9:51
 * Project:CodeSnippet
 */
package fastjson;


import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;

import static java.time.temporal.ChronoUnit.DAYS;


public class Test {
    public static void main(String[] args) throws Exception{
//
//        Prize a = new Prize();
//        a.setName("1");
//        Prize b = new Prize();
//        b.setName("1");
//        List<Prize> prizes = new ArrayList<>();
//        prizes.add(a);
//        prizes.add(b);
//        String json = JSON.toJSONString(prizes);
//
//        ArrayList<Prize> list = (ArrayList<Prize>) JSON.parseArray(json, Prize.class);
//        System.err.println(list);
//
//        long total = 1;
//        int pageSize = 15;
//
//        int totl =  (int)Math.round(Math.ceil(total / pageSize));
//        System.err.println(totl);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(1565143200000L), ZoneId.systemDefault());
        LocalDateTime curTime = LocalDateTime.of(2019, 8, 8, 10, 0, 0);
//        System.err.println(localDateTime);
//        int days = Period.between(localDateTime.toLocalDate(), curTime.toLocalDate()).getDays();
//
//        System.err.println(days);
//        System.err.println(curTime.minusMonths(1).toLocalDate());

       long  day =  DAYS.between(localDateTime.toLocalDate(), curTime.toLocalDate());

//        int d
// ays = DAYS.between(dateBefore, dateAfter);(localDateTime.toLocalDate(), curTime.toLocalDate()).getDays();

//            D

//
//        LocalDateTime old = LocalDateTime.ofInstant(Instant.ofEpochMilli(1561604768972L), ZoneId.systemDefault());
//        LocalDateTime cur = LocalDateTime.of(2019, 07, 5, 0, 0, 0);
//
//        Long days = Duration.between(old, cur).toDays();
//
//        int  day = Period.between(old.toLocalDate(), cur.toLocalDate()).getDays();
//
//
//
//        System.err.println(days);
//        System.err.println(days);
        System.err.println(day);







    }
}
