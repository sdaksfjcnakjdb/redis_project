package redis.Service;

import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.Map;

@Service
public class RedisHash {

    Jedis jedis = RedisJedis.getJedis();

    public Jedis getJedis() {
        return jedis;
    }

    public void setJedis(Jedis jedis) {
        this.jedis = jedis;
    }


    /**
     * 输入名字hash，键值key，值value，保存
     * */
    public void hashPushRedis(String hash,String key,String value){
        jedis.hset(hash,key,value);
    }

    /**
     * 删除hash字典
     * */
    public void hashRemoveRedis(String hash){
        jedis.del(hash);
    }

    /**
     * 获取字典值
     * */
    public Map<String,String> hashGetRedis(String hash){
        return jedis.hgetAll(hash);
    }

    /**
     * 获取字典中key对应的value值
     * */
    public String hashGetRedis(String hash,String key){
        return jedis.hget(hash,key);
    }

    /**
     * 获取字典长度
     * */
    public long hashGetLenRedis(String hash){
        return jedis.hlen(hash);
    }




}
