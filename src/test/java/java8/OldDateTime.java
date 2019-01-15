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
    public static void main(String[] args) {
        Date date = new Date();

        System.err.println(date);
        Calendar calendar = Calendar.getInstance();
        Long time = calendar.getTimeInMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+07:00"));
        String today = sdf.format(new Date(time));
        System.err.println(today);









        System.err.println(calendar);

        TimeZone zone = TimeZone.getDefault();
        System.err.println(zone);
    }
}
