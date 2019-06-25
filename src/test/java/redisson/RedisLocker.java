/**
 * Description:
 * User: daipeng
 * Date: 2019-01-24 16:22
 * Project:BookEventWeb
 */
package redisson;

import io.lettuce.core.RedisClient;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import java.util.concurrent.TimeUnit;


/**
 * redis 锁
 */
public class RedisLocker implements AutoCloseable {

    private String lockKey;
    //毫秒 默认加锁时间是10秒
    private Long expireTime = 10L;

    private TimeUnit unit = TimeUnit.SECONDS;

    private RLock rLock;

    private RedissonClient client;

    public RedisLocker(String lockKey, RedissonClient client) {
        this.lockKey = lockKey;
        this.client = client;
        lock(lockKey,expireTime, unit);
    }

    public RedisLocker(String lockKey, Long expireTime, TimeUnit unit) {
        this.lockKey = lockKey;
        this.expireTime = expireTime;
        this.unit = unit;
        lock(lockKey,expireTime, unit);
    }

    private void lock(String key, Long expireTime, TimeUnit unit) {
        rLock = client.getLock(key);
         rLock.lock(expireTime, unit);
    }

    public boolean isLocked() {
        return rLock.isLocked();
    }

    @Override
    public void close() throws Exception {
        rLock.unlock();
    }
}
