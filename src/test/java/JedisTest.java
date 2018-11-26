import com.sun.org.apache.bcel.internal.generic.DUP;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import java.time.Duration;
import java.time.Instant;

/**
 * Created by lvlvforever on 2018/11/16.
 */
public class JedisTest {
    public static void main(String[] args) {

        Jedis jedis = new Jedis("192.168.2.132", 6379);
        jedis.auth("foobared");
        Instant now = Instant.now();


//        for (int i = 0; i < 1000000; i++) {
//            jedis.set("key" + i, "QWEQWEWQEQWEQEQWEQWEWQEQWEWQEWQEWQEWQEWQEWQEWQEQEWQEQWEWQ");
//        }
    Instant        end = Instant.now();

        Duration duration = Duration.between(now, end);
        System.err.println(duration.toMillis());

         now = Instant.now();


        Pipeline pipeline = jedis.pipelined();


        for (int i = 0; i < 50000000; i++) {
            pipeline.set("key" + i, "QWEQWEWQEQWEQEQWEQWEWQEQWEWQEWQEWQEWQEWQEWQEWQEQEWQEQWEWQ"+i);
        }
        pipeline.sync();




         end = Instant.now();
         duration = Duration.between(now, end);
        System.err.println(duration.toMillis());

    }
}
