package redis;

import com.sun.javafx.fxml.BeanAdapter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.Bean.Book;
import redis.Controller.RedisController;

public class redistest {
    private static ApplicationContext context =
            new ClassPathXmlApplicationContext("spring_redis.xml");


    @Test
    public void testaop(){
        RedisController redisController = context.getBean(RedisController.class);
//        redisController.redislists();
//        redisController.redisSet();
//        redisController.redisSortSet();
        redisController.redisHash();
    }
}
