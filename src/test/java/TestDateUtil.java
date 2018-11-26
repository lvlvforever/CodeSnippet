import org.apache.xmlbeans.impl.xb.xsdschema.impl.LocalComplexTypeImpl;

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
