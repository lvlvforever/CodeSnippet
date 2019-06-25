/**
 * Description:
 * User: daipeng
 * Date: 2019-01-24 16:22
 * Project:BookEventWeb
 */
package lettuce;

/**
 *
 */
public class RedisLocker implements AutoCloseable {
//
//    private String lockKey;
//    private String requestId = ToolUtil.getRequestId();
//    //毫秒 默认加锁时间是10秒
//    private int expireTime = 10 * 1000;
//
//    private boolean locked = false;
//
//
//    public RedisLocker(String lockKey) {
//        this.lockKey = lockKey;
//        lock();
//    }
//
//    public RedisLocker(String lockKey, int expireTime) {
//        this.lockKey = lockKey;
//        this.expireTime = expireTime;
//        lock();
//    }
//
//    public RedisLocker(String lockKey, String requestId, int expireTime) {
//        this.lockKey = lockKey;
//        this.requestId = requestId;
//        this.expireTime = expireTime;
//        lock();
//    }
//
//    private void lock() {
//
//        if (ConfigInit.isDevEnv()) {
//            locked = true;
//        }else{
//            Jedis jedis = JEDIS_CLIENT.getJedis();
//            this.locked = YwRedisExtUtil.tryGetDistributedLock(jedis, this.lockKey, this.requestId, this.expireTime);
//            if (jedis != null) {
//                jedis.close();
//            }
//        }
//
//    }
//
//    public boolean isLocked() {
//
//        return locked;
//    }
//
    @Override
    public void close() throws Exception {
//        if (!ConfigInit.isDevEnv()) {
//            Jedis pureJedis = JEDIS_CLIENT.getJedis();
//            YwRedisExtUtil.releaseDistributedLock(pureJedis, this.lockKey, this.requestId);
//            if (pureJedis != null) {
//                pureJedis.close();
//            }
//        }
    }
}
