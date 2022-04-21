package redis.Service;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.Set;

@Service
public class RedisSortSet {
    Jedis jedis = RedisJedis.getJedis();

    public void setJedis(Jedis jedis) {
        this.jedis = jedis;
    }

    /**
     传入名字sortSet，键值key，排序权重score，将键值key插入到sortSet中去。
     * */
    public void sortSetPushRedis(String sortSet,int score,String node){
        jedis.zadd(sortSet,score,node);
    }

    /**
     * 传入名字sortSet,升序返回sortSet数据。
     * */
    public Set<String> sortSetRangeRedis(String sortSet){
        return jedis.zrange(sortSet,0,-1);
    }

    /**
     * 传入名字sortSet,降序返回sortSet数据。
     * */
    public Set<String> sortSetRevrangeRedis(String sortSet){
        return jedis.zrevrange(sortSet,0,-1);
    }

    /**
     * 传入名字sortSet,返回sortSet列表总量
     * */
    public long sortSetSizeRedis(String sortSet){
        return jedis.zcard(sortSet);
    }

    /**
     * 传入名字sortSet,权重began，权重end,返回sortSet中began权重到end权重中的数据。
     * */
    public Set<String> sortSetSizeRedis(String sortSet, int began, int end){
        return jedis.zrangeByScore(sortSet,began,end);
    }

    /**
     * 传入名字sortSet,键值node，返回sortSet中node在升序中的下标
     * */
    public long sortSetRankRedis(String sortSet, String node){
        return jedis.zrank(sortSet,node);
    }

    /**
     * 传入名字sortSet,键值node，返回sortSet中node在降序中的下标
     * */
    public long sortSetRevRankRedis(String sortSet, String node){
        return jedis.zrevrank(sortSet,node);
    }

    /**
     * 传入名字sortSet,键值node，从sortSet中删除node
     * */
    public void sortSetRemoveRedis(String sortSet, String node){
        jedis.zrem(sortSet,node);
    }





}
