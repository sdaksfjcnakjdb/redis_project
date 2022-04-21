package redis.Service;

import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.Set;

@Service
public class RedisSet {
    Jedis jedis = RedisJedis.getJedis();

    public void setJedis(Jedis jedis) {
        this.jedis = jedis;
    }

    public void setpush(String set, String node){
    }

    /**
     * 压入node到set中
     * */
    public void setPushRedis(String set,String node){
        jedis.sadd(set,node);
    }

    /**
     * 删除set
     * */
    public void setRemoveRedis(String set){
        jedis.spop(set);
    }

    /**
     * 查询set
     * */
    public Set setSelectRedis(String set){
        return  jedis.smembers(set);
    }

    /**
     * 查询node是否在set中
     * */
    public Boolean setTFRedis(String set,String node){
        return jedis.sismember(set,node);
    }

    /**
     * 返回set的大小
     * */
    public Long setSizeRedis(String set){
        return jedis.scard(set);
    }
}
