/**
 * Description:
 * User: daipeng
 * Date: 2018-12-20 15:29
 * Project:CodeSnippet
 */
package oscar;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.LoggingPermission;

public class Oscar {
    public static void main(String[] args) {
        System.err.println("start");

        Jedis jedis = new Jedis("121.41.56.8", 6379);
        jedis.auth("foobared");
        Instant begin = Instant.now();


//        List<String> a = jedis.lrange("collection", 0, -1);
//        System.err.println(a.size());
//
//        Instant end = Instant.now();
//        System.err.println("over" + Duration.between(begin, end).toMillis());

        LocalDate now = LocalDate.now();
        System.err.println(now.plusDays(69));








//
//        Pipeline pipeline = jedis.pipelined();
//        Map<String, String> total = new HashMap<>();
//        for (int i = 0; i < 200000; i++) {
//            String time = Instant.now().toEpochMilli() + "" + i;
//            total.put(time, i+"");
//            pipeline.lpush("collection", time);
//        }
//        System.err.println("pipelined"+total.size());
//        pipeline.sync();





    }
}
