package redis.Controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import redis.Bean.Student;
import redis.Service.RedisHash;
import redis.Service.RedisList;
import redis.Service.RedisSet;
import redis.Service.RedisSortSet;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
@Controller
public class RedisController {

    @Autowired
    RedisList redisList;

    @Autowired
    RedisSet redisSet;

    @Autowired
    RedisSortSet redisSortSet;

    @Autowired
    RedisHash redisHash;


    @Autowired
    Student student;

    @Autowired
    RedisTemplate redisTemplate;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }


    public RedisList getRedisList() {
        return redisList;
    }

    public void setRedisList(RedisList redisList) {
        this.redisList = redisList;
    }

    @Test
    public void redisTester() {
        Jedis jedis = new Jedis("localhost", 6379, 100000);
        int i = 0;
        try {
            long start = System.currentTimeMillis();// 开始毫秒数
            while (true) {
                long end = System.currentTimeMillis();
                if (end - start >= 1000) {// 当大于等于1000毫秒（相当于1秒）时，结束操作
                    break;
                }
                i++;
                jedis.set("test" + i, i + "");
            }
        } finally {// 关闭连接
            jedis.close();
        }
        // 打印1秒内对Redis的操作次数
        System.out.println("redis每秒操作：" + i + "次");
    }

    @Test
    public void spring() {
        student.setName("我没有三颗心脏");
        student.setAge(21);
        long start = System.currentTimeMillis();// 开始毫秒数
        int i = 0;
        while (true) {
            long end = System.currentTimeMillis();// 开始毫秒数
            if (end-start<1000) {
                redisTemplate.opsForValue().set("student_1", student);
                i++;
            }else{
                break;
            }
        }
        System.out.println(i);

    }


    public void redislists(){
        redisList.listPushResit("mylist","a");
        redisList.listPushResit("mylist","b");
        redisList.listRemoveAllResitTest("mylist","a");
        redisList.listRemoveAllResitTest("mylist","b");
        System.out.println("list:"+redisList.listGetListResi("mylist"));
    }

    public void redisSet(){
        redisSet.setPushRedis("myset","a");
        redisSet.setPushRedis("myset","b");
        System.out.println(redisSet.setSelectRedis("myset"));
        System.out.println(redisSet.setSizeRedis("myset"));
        System.out.println(redisSet.setTFRedis("myset","t"));
        redisSet.setRemoveRedis("myset");
        System.out.println("remove....");
        System.out.println(redisSet.setSelectRedis("myset"));
        System.out.println(redisSet.setSizeRedis("myset"));
    }



    public void redisSortSet(){
        redisSortSet.sortSetPushRedis("mysortset",0,"a");
        redisSortSet.sortSetPushRedis("mysortset",1,"b");
        redisSortSet.sortSetPushRedis("mysortset",0,"c");
        System.out.println(redisSortSet.sortSetRangeRedis("mysortset"));
        System.out.println(redisSortSet.sortSetSizeRedis("mysortset"));
    }


    public void redisHash(){
        redisHash.hashPushRedis("myhash","key01","value01");
        redisHash.hashPushRedis("myhash","key02","value02");
        redisHash.hashPushRedis("myhash","key03","value03");

        System.out.println(redisHash.hashGetRedis("myhash"));
        System.out.println(redisHash.hashGetRedis("myhash","key01"));
        System.out.println(redisHash.hashGetLenRedis("myhash"));

        redisHash.hashRemoveRedis("myhash");
    }
}
