/**
 * Description:
 * User: daipeng
 * Date: 2018-12-31 15:14
 * Project:CodeSnippet
 */
package basic;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.*;

public class BitSetTestV2 {
    public static void main(String[] args) throws  Exception {

//        List<BitSet> bitSets = new ArrayList<>();
//        for (int i = 0; i < 168; i++) {
//            BitSet b = new BitSet();
//            for (int k = 0; k < 700000; k++) {
//                b.set(i, true);
//            }
//            bitSets.add(b);
//        }

        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < 700000; i++) {
            a.add(i);
        }
//        System.err.println("over"+a.size());
//        Thread.sleep(10000000);
//


//        List<Map<String, Object>> list = new ArrayList<>();
//        Map<String, Object> map = new HashMap<>();
//        map.put("name", "daipeng");
//        List<Map<String, String>> book = new ArrayList<>();
//        Map<String, String> aBook = new HashMap<>();
//        aBook.put("titlk", "fdsfdsf");
//        book.add(aBook);
//        map.put("book", book);
//        list.add(map);
//        map = new HashMap<>();
//        map.put("name", "zhaoqian");
//        list.add(map);
//        String b = JSON.toJSONString(list);
//        System.err.println(b);
//
//        List<Map<String, String>> c = (List)JSON.parseArray(b, Map.class);
//        System.err.println(  c.get(0).get("name"));
//        System.err.println(c);



        Map<String, Object> map = new HashMap<>();
        map.put("name", "daipeng");
        String s = JSON.toJSONString(map);
        Map<String, Object> result = JSON.parseObject(s, Map.class);
        System.err.println(result);









    }
}
