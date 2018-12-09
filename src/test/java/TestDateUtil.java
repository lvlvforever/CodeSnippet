import org.apache.xmlbeans.impl.xb.xsdschema.impl.LocalComplexTypeImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.acl.LastOwnerException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

/**
 * Created by lvlvforever on 2018/11/15.
 */
public class TestDateUtil {
    public static void main(String[] args) {

        LocalDate date = LocalDate.parse("2015-11-20");
        MonthDay monthDay = MonthDay.of(date.getMonth(), date.getDayOfMonth());
        MonthDay today = MonthDay.from(LocalDate.now());
        System.err.println(today.equals(monthDay));
        System.err.println(monthDay);

        YearMonth yearMonth = YearMonth.from(LocalDate.now());
        System.err.println(yearMonth);
        System.err.println(LocalDate.now().isLeapYear());

        System.err.println(new Date().toInstant());
        Instant instant = new Date().toInstant();
        LocalDateTime time = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.err.println(time);
        System.err.println(new Date());


        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.err.println(list.stream().mapToInt(Integer::intValue).sum());



        try {
            File file = new File("c:\\aaa");
            InputStream inputStream = new FileInputStream(file);
        } catch (IOException e) {
            System.err.println(e);
        }
        System.err.println("catch catch");

        LocalDateTime replyTime = LocalDateTime.now();
        System.err.println(replyTime.format(DateTimeFormatter.ofPattern("HH:mm")));




    }
    class A {
        public A(){
            return;
        }
    }


















    public static List<Long> getRandomSeq(Long totalCount, Integer needCount) {
        List<Long> result = new ArrayList<>();
        if (totalCount < needCount) {
            return result;
        }
        result = LongStream.range(0, totalCount).boxed().collect(toList());
        Collections.shuffle(result);
        return result.stream().limit(needCount).collect(Collectors.toList());
    }

}
