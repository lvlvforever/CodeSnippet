import com.sun.org.apache.bcel.internal.generic.DUP;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by lvlvforever on 2018/11/16.
 */
public class JedisTest {
    public static void main(String[] args) {

        Jedis jedis = new Jedis("121.41.56.8", 6379);
        jedis.auth("foobared");
        String test = jedis.get("cname");
        System.err.println(test);
        Instant now = Instant.ofEpochMilli(1543852794000L);
        System.err.println(now.atZone(ZoneId.systemDefault()).toLocalDateTime());





        LocalDateTime expireTime = LocalDateTime.now().plusDays(3);
        Long expireTimeInMillions = expireTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        System.err.println(expireTimeInMillions);


        Map<String, String> map = new TreeMap<>();
        map.put("1", "1");

        map.put("5", "5");
        map.put("6", "6");
        map.put("7", "7");
        map.put("2", "2");
        map.put("3", "3");

        map.put("8", "8");
        map.put("4", "4");

        for (Map.Entry<String, String> entry : map.entrySet()) {

            System.err.println(entry.getKey());
        }


    }
}
