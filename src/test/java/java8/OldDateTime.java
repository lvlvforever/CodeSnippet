/**
 * Description:
 * User: daipeng
 * Date: 2018-12-25 21:56
 * Project:CodeSnippet
 */
package java8;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class OldDateTime {

    private static final Date date = new Date();

    public static void main(String[] args) {

        //第一次方法调用
        Date curDate = getCurDate();
        System.err.println("第一次调用"+curDate);
        curDate.setTime(curDate.getTime() + 1000000L);
        //第二次方法调用
        curDate = getCurDate();
        System.err.println("第二次调用"+curDate);





        Date date = new Date();
        System.err.println(date);





        System.err.println(date.getMonth());

        System.err.println(date.getYear());


        System.err.println(date.getTime());


        Calendar calendar = Calendar.getInstance();
        Long time = calendar.getTimeInMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+07:00"));
        String today = sdf.format(new Date(time));
        System.err.println(today);


        Date date1 = new Date(2019, 11, 12);
        System.err.println(date1);




    }

    public static Date getCurDate() {
        //some other operations ...
        //System.err.println(date);

        return date;
    }





}
