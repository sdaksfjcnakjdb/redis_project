package redis.Service;

import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
@Service
public class RedisJedis {
    static Jedis jedis = new Jedis("localhost", 6379, 100000);
    public static Jedis getJedis() {
        return jedis;
    }
}
