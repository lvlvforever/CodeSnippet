/**
 * Description:
 * User: daipeng
 * Date: 2019-05-24 10:19
 * Project:CodeSnippet
 */
package lettuce;

import io.lettuce.core.*;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisAsyncCommands;
import io.lettuce.core.api.sync.RedisCommands;
import io.lettuce.core.codec.CompressionCodec;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import redisson.User;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Lettuce {
    public static void main(String[] args) {

//
//        Map<String, String> name = new HashMap<>();
//        name.put("daipeng", "123");
//        name.put("daipeng2", "123");
//
//
//        Map<String, String> nname = name.entrySet().stream().collect(Collectors.toMap(key -> "dd" + key.getKey(), value -> value.getValue()));
//        nname.put("aa", "11");
//
////        System.err.println(nname);
//
//
//        name = nname.entrySet().stream().filter(entry -> entry.getKey().startsWith("dd")).collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
////        System.err.println(name);
//
//        name = null;
//        name.entrySet().stream().forEach(k -> System.err.println(k.getKey()));
//
//







        RedisClient redisClient = RedisClient.create("redis://bigDay!@47.95.241.168:6379/0");

        StatefulRedisConnection<String, String> connection = redisClient.connect();
        RedisCommands<String, String> syncCommands = connection.sync();
//        Long now = System.currentTimeMillis();
//        Map<String, String> map = new HashMap<>();
//
//        map.put("name", "daipeng");
//        map.put("age", "30");
//
//        syncCommands.hmset("student", map);
//
//        Long cur = System.currentTimeMillis();
//
//
//        String value = syncCommands.eval("return {KEYS[1],KEYS[2]}", ScriptOutputType.VALUE, "daipeng", "hahah");
        Long time = System.currentTimeMillis();
        Map<String, String> add = syncCommands.hgetall("student");
        Map<String, String> b = syncCommands.hgetall("student");
        Map<String, String> c = syncCommands.hgetall("student");
        Map<String, String> d = syncCommands.hgetall("student");
        Map<String, String> e = syncCommands.hgetall("student");
        Long test = System.currentTimeMillis();
        System.err.println(test - time);













        Long now = System.currentTimeMillis();
        RedisAsyncCommands<String, String> asyncCommands = connection.async();






        asyncCommands.setAutoFlushCommands(false);
        List<RedisFuture<Map<String,String>>> futures = new ArrayList<>();
        futures.add(asyncCommands.hgetall("student"));
        futures.add(asyncCommands.hgetall("student"));
        futures.add(asyncCommands.hgetall("student"));
        futures.add(asyncCommands.hgetall("student"));
        futures.add(asyncCommands.hgetall("student"));
        asyncCommands.flushCommands();
        boolean result = LettuceFutures.awaitAll(5, TimeUnit.SECONDS, futures.toArray(new RedisFuture[futures.size()]));
        Long time2 = System.currentTimeMillis();
        System.err.println(time2-now);
        if (result == true) {

            try {
                for (int i = 0; i < 5; i++) {
                    Map<String, String> map = futures.get(i).get();
                    System.err.println(i);
                    System.err.println(map);
                }

                



            } catch (InterruptedException e2) {
                e2.printStackTrace();
            } catch (ExecutionException e1) {
                e1.printStackTrace();
            }


        }

        connection.close();


    }
}
