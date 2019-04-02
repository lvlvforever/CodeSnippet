/**
 * Description:
 * User: daipeng
 * Date: 2018-12-14 11:32
 * Project:CodeSnippet
 */
package java8;

import com.alibaba.fastjson.JSON;
import org.omg.PortableInterceptor.INACTIVE;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class DateTimeTest {
    public static void main(String[] args) {



        LocalDateTime nowLocalDateTime = LocalDateTime.now();

        System.err.println(nowLocalDateTime);

        Date date = new Date();


        LocalDateTime localDateTime = LocalDateTime.of(2019, 1, 15, 22, 24, 0);

        //LocalDateTime thirddate = LocalDateTime.of(2019, 1, 13, 21, 0, 1);
        System.err.println(Duration.between(nowLocalDateTime, localDateTime).toMinutes());


        System.err.println(parseTimeOscar(1547276640000L));


        nowLocalDateTime.getMonth();


        Map<String, String> a = new LinkedHashMap<>();
        a.put("a", "a");
        a.put("b", "b");

//        Duration.between()



        System.err.println(new Date().toInstant());
        Instant instant = new Date().toInstant();

        Date date1 = Date.from(instant);
        System.err.println(date1);



        //LocalDateTime time = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
        //System.err.println(time);
        System.err.println(date1);


        LocalDateTime newYear = LocalDateTime.of(2019, 1, 1, 0, 0, 0);

















    }

    public static String parseTimeOscar(long time) {
        Instant instant = Instant.ofEpochMilli(time);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return localDateTime.getMonthValue() + "月" + localDateTime.getDayOfMonth() + "日" + localDateTime.getHour() + "时" + localDateTime.getMinute() + "分";
    }

    private static Map<String, LocalDateTime> sort(Map<String, LocalDateTime> map) {
        Map<String, LocalDateTime> sortedMap = new LinkedHashMap<>();
        List<Map.Entry<String, LocalDateTime>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, LocalDateTime>>() {
            @Override
            public int compare(Map.Entry<String, LocalDateTime> o1, Map.Entry<String, LocalDateTime> o2) {

                return o1.getValue().compareTo(o2.getValue());
//                return (int)(o1.getValue().atZone(ZoneId.systemDefault()).toEpochSecond() - o2.getValue().atZone(ZoneId.systemDefault()).toEpochSecond());
            }

        });
        System.err.println(list);

        for (Map.Entry<String, LocalDateTime> entry : list) {
            System.err.println(entry.getKey()+"="+entry.getValue());
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }


}
class Tmp {
    public String name;
}
