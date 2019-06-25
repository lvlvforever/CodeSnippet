package lettuce;

import io.lettuce.core.ScriptOutputType;
import io.lettuce.core.SetArgs;
import io.lettuce.core.api.sync.RedisCommands;
import redis.clients.jedis.Jedis;

import java.util.Collections;

public class YwRedisExtUtil {
	private static final String LOCK_SUCCESS = "OK";

    private static final Long RELEASE_SUCCESS = 1L;
    
    /**
     * 释放分布式锁
     * @param lockKey 锁
     * @param requestId 请求标识
     * @return 是否释放成功
     */
    public static boolean releaseDistributedLock(RedisCommands<String, String> syncCommands, String lockKey, String requestId) {
 
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
		Long  result = syncCommands.eval(script, ScriptOutputType.INTEGER, new String[]{lockKey}, requestId);

		System.err.println(result);
        if (RELEASE_SUCCESS.equals(result)) {
            return true;
        }
        return false;
 
    }
    /**
     * 尝试获取分布式锁
     *
     * @param lockKey 锁
     * @param requestId 请求标识
	 * @param expireTime 超期时间 时间单位是PX 毫秒
     * @return 是否获取成功
     */
    public static boolean tryGetDistributedLock(RedisCommands<String, String> syncCommands,String lockKey, String requestId, int expireTime) {

		SetArgs args = SetArgs.Builder.px(expireTime).nx();
        String result = syncCommands.set(lockKey, requestId, args);
		System.err.println("get lock "+ result);
        if (LOCK_SUCCESS.equals(result)) {
            return true;
        }
        return false;
 
    }

}
