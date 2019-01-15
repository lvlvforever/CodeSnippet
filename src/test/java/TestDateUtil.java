import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.sun.org.apache.xpath.internal.operations.Bool;
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




        System.err.println("catch catch");

        LocalDateTime replyTime = LocalDateTime.now();
        System.err.println(replyTime.format(DateTimeFormatter.ofPattern("HH:mm")));

        System.err.println(test());


        Activity a = new Activity();
        Activity b = new Activity();
        Activity c = new Activity();
        a.startTime = "2018-11-12 10:00:01";
        b.startTime = "2018-11-13 09:00:11";
        c.startTime = "2018-11-11 19:00:01";
        List<Activity> values = new ArrayList<>();
        values.add(a);
        values.add(b);
        values.add(c);
        Collections.sort(values, new Activity.SortByStartTime(-1));


        List<Activity> sub = values.subList(0, values.size());


        for (Activity obj : sub) {
            System.err.println(obj.startTime);
        }

        Calendar.getInstance().getTimeInMillis();


        String s = " []";
        JSONArray arr = JSON.parseArray(s);
        System.err.println(arr.size());

        Set<Long> set = new HashSet<>();
        set.add(1L);
        set.add(2L);
        set.add(3L);
        List<Long> parent = new ArrayList<>(set);

        parent = parent.subList(0, 1);
        System.err.println(parent);


        String flag = "false";
        System.err.println(Boolean.valueOf(flag));


        LocalDateTime ran = LocalDateTime.of(2019, 1, 07, 21, 0, 0);
        LocalDateTime now = LocalDateTime.now();
        System.err.println(Duration.between(now, ran).toMillis() / 1000);


        LocalDate localDate = LocalDate.of(2019, 1, 8);
        LocalDate nowDate = LocalDate.now();

        Integer which = Period.between(localDate,nowDate).getDays();
        System.err.println(which);











    }

    public static String test() {

        try {
            File file = new File("c:\\aaa");
            InputStream inputStream = new FileInputStream(file);
        } catch (IOException e) {
            return "catch";
        }
        return "normal";



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
