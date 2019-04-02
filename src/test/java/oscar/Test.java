/**
 * Description:
 * User: daipeng
 * Date: 2019-01-08 15:58
 * Project:CodeSnippet
 */
package oscar;

import org.apache.commons.lang3.math.NumberUtils;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {

        System.err.println(NumberUtils.isParsable("11555"));


        Integer[] a = new Integer[]{1, 23, 4};
        Arrays.stream(a).map(k -> k+1).collect(Collectors.toSet());











    }
    public static Map<String, LocalDateTime> sort(Map<String, LocalDateTime> map) {
        Map<String, LocalDateTime> sortedMap = new LinkedHashMap<>();
        List<Map.Entry<String, LocalDateTime>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, LocalDateTime>>() {
            @Override
            public int compare(Map.Entry<String, LocalDateTime> o1, Map.Entry<String, LocalDateTime> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }

        });
        for (Map.Entry<String, LocalDateTime> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
}
