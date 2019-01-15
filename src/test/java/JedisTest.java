import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.bcel.internal.generic.DUP;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by lvlvforever on 2018/11/16.
 */
public class JedisTest {
    public static void main(String[] args) throws Exception {

        Jedis jedis = new Jedis("121.41.56.8", 6379);
        jedis.auth("foobared");
        jedis.del("tet");

        jedis.lpush("tet", "1");
        jedis.lpush("tet", "2");
        jedis.lpush("tet", "3");
        jedis.lpush("tet", "4");


        List<Integer> value = new ArrayList<>();
        value.add(333);
        value.add(344);
        value.add(353);
        value.add(363);


        LocalDateTime localDateTime = LocalDateTime.of(2019, 1, 16, 2, 0, 0);
        LocalDateTime now = LocalDateTime.now();
        if (now.isBefore(localDateTime)) {
            for (int i = 0; i < value.size(); i++) {
                value.set(i, value.get(i) - 263);
            }


        }
        System.err.println(value);





//        List<String> aaa = jedis.lrange("tet", 2, 3);
//        System.err.println(aaa);

//        map.put("4", "4");
//
//        for (Map.Entry<String, String> entry : map.entrySet()) {
//
//            System.err.println(entry.getKey());
//        }


    }
}
