/**
 * Description:
 * User: daipeng
 * Date: 2019-07-09 11:26
 * Project:CodeSnippet
 */
package java8;

import basic.Local;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class TestTime {

    public static void main(String[] args) {


//        LocalDateTime old = LocalDateTime.ofInstant(Instant.EPOCH, ZoneId.systemDefault());
        LocalDateTime old = LocalDateTime.of(2018, 01, 8, 0, 1, 1);
        LocalDateTime cur = LocalDateTime.now();
        Period period = Period.between(old.toLocalDate(), cur.toLocalDate());

        Duration duration = Duration.between(old, cur);



        System.err.println("period="+period);
        System.err.println("period year="+period.getYears());
        System.err.println("period month="+period.getMonths());
        System.err.println("period day="+period.getDays());


        System.err.println("duration="+duration);
        //to表示有转换
        System.err.println("duration hours="+duration.toHours());
        System.err.println("duration minute="+duration.toMinutes());
        //get表示没有转换
        System.err.println("duration seconds="+duration.getSeconds());


        long days = ChronoUnit.DAYS.between(old, cur);
        System.err.println("相距天数="+days);



        LocalDate oldDay = LocalDate.of(2019, 07, 8);
        LocalDate today = LocalDate.of(2019, 07, 10);
        long gap = ChronoUnit.DAYS.between(oldDay, today);
        System.err.println("相距天数="+gap);


    }
}
