/**
 * Description:
 * User: daipeng
 * Date: 2018-12-07 16:11
 * Project:CodeSnippet
 */
package basic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListTest {
    public static void main(String[] args) {
//        List<Integer> a = new ArrayList<>();
//        a.add(1);
//        a.add(2);
//        a.add(3);
//        a.add(4);
//        a.add(5);
//
//        List<Integer> b = null;
//
//
//        a.retainAll(b);
//        System.err.println(a);
//
//        for (Integer t : b) {
//            System.err.println(t);
//        }
//

        List<String> list = new ArrayList<>();
        list.add("0");
        list.add("1");
        List<Integer> integers = list.stream().map(k -> Integer.valueOf(k)).collect(Collectors.toList());
        System.err.println(integers);



    }
}
