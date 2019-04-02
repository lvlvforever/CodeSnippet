/**
 * Description:
 * User: daipeng
 * Date: 2019-01-17 11:37
 * Project:CodeSnippet
 */
package java8;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjuster;

import static java.time.temporal.TemporalAdjusters.*;

public class ComplexDemo {
    public static void main(String[] args) {

//        当前月的第二个星期五



        LocalDateTime cur = LocalDateTime.now();
        LocalDateTime second = cur.with(dayOfWeekInMonth(2, DayOfWeek.FRIDAY));



        //当前月的最后一个星期五




        LocalDateTime last = cur.with(dayOfWeekInMonth(-1, DayOfWeek.FRIDAY));


        LocalDateTime lastMonday = cur.with(previous(DayOfWeek.MONDAY));



        LocalDateTime lastThursday = cur.with(previous(DayOfWeek.THURSDAY));




        LocalDateTime lastThursdayOrSame = cur.with(previousOrSame(DayOfWeek.THURSDAY));




        LocalDateTime nextThursdayOrNow = cur.with(nextOrSame(DayOfWeek.THURSDAY));



        System.err.println("当前月的第二个星期五："+second);
        System.err.println("当前月的最后一个星期五："+last);
        System.err.println("上一个星期一："+lastMonday);
        System.err.println("上一个星期四："+lastThursday);
        System.err.println("上一个星期四，如果今天是周四，则返回今天："+lastThursdayOrSame);
        System.err.println("下一个星期四，如果今天是周四，则返回今天："+nextThursdayOrNow);

        System.err.println(cur.plusMonths(1).with(dayOfWeekInMonth(-1,DayOfWeek.FRIDAY)));


        TemporalAdjuster adjuster = new NextWorkingDay();
        LocalDateTime friday = LocalDateTime.of(2019, 1, 18,0,0,0);
        LocalDateTime nextWorkingDay = friday.with(adjuster);
        System.err.println(nextWorkingDay);





//        LocalDateTime localDateTime = LocalDateTime.of(2019, 1, 31, 0, 0, 0);
//        System.err.println(localDateTime.plusMonths(1));

    }
}
