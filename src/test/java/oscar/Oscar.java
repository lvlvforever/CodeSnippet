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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Oscar {
    public static void main(String[] args) {
        System.err.println("start");

        Jedis jedis = new Jedis("121.41.56.8", 6379);
        jedis.auth("foobared");
        Instant begin = Instant.now();


        List<String> a = jedis.lrange("collection", 400000, 400000);
        System.err.println(a);

        Instant end = Instant.now();
        System.err.println("over" + Duration.between(begin, end).toMillis());








//        Pipeline pipeline = jedis.pipelined();
//        Map<String, String> total = new HashMap<>();
//        for (int i = 0; i < 700000; i++) {
//            String time = Instant.now().toEpochMilli() + "" + i;
//            total.put(time, i+"");
//            pipeline.lpush("collection", time);
//        }
//        System.err.println("pipelined"+total.size());
//        pipeline.sync();





    }
}
