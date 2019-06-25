/**
 * Description:
 * User: daipeng
 * Date: 2019-05-17 14:16
 * Project:CodeSnippet
 */
package redisson;

import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.Config;
import org.redisson.config.TransportMode;

import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception{
        Config config = new Config();
        config.setCodec(new  org.redisson.codec.SnappyCodec());

        config.useReplicatedServers().addNodeAddress("redis://47.95.241.168:6379").setPassword("bigDay!");
        RedissonClient client = Redisson.create(config);

//        RBucket<String> key = client.getBucket("redisson");
//        key.set("daipeng");
//
//        RBucket<String> remote = client.getBucket("redisson");
//        System.err.println(remote.get());
//
//
//        RMap<String, String> map = client.getMap("user");
//        map.put("name", "wang");
//        map.put("number", "123");



        RBucket<User> bucket = client.getBucket("123");
//        bucket.set(new User("diapeng", 123));

        User user = bucket.get();
        System.err.println(user.getName());
        System.err.println(user.getNumber());

        System.err.println( user);




//
//        new Thread(() -> {
//
//
//
//            try (RedisLocker locker = new RedisLocker("daipeng", client)) {
//                if (locker.isLocked()) {
//
//
//                    System.err.println("hahahaha i get the lock");
//
//                    Thread.sleep(10000);
//
//                }else{
//                    System.err.println("hahah  my god");
//
//                }
//
//
//
//
//            } catch (Exception e) {
//                System.err.println("hahah " + e);
//            }
//
//
//
//        }).start();
//
//        new Thread(() -> {
//
//
//
//            try (RedisLocker locker = new RedisLocker("daipeng", client)) {
//                if (locker.isLocked()) {
//
//
//                    System.err.println("yayayay   i get the lock");
//
//                    Thread.sleep(10000);
//
//                }else{
//                    System.err.println("yayayay  my god");
//
//                }
//
//
//
//
//            } catch (Exception e) {
//                System.err.println("yayaya" + e);
//            }
//
//
//
//        }).start();


        client.shutdown();

//
//        Integer a = 1;
//        int b = 1;
//        System.err.println(a.equals(b));
//
//        String text = "测试菱形方块";
//        System.err.println(text.getBytes("GBK"));

    }
}
