package redis.Service;

import org.junit.Test;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.List;
@Service
public class RedisList {

    Jedis jedis = RedisJedis.getJedis();

    public void setJedis(Jedis jedis) {
        this.jedis = jedis;
    }


    //添加元素(默认添加在右侧
    public void listPushResit( String list,String node,String push){
        if(push.equals("left")) {
            jedis.lpush(list, node);
        }else{
            // leftPush依次由左边添加
            jedis.lpush(list, node);
        }
    }
    public void listPushResit( String list,String node){
            jedis.lpush(list, node);
            System.out.println("push");
    }

    //查询元素
    public List<String> listGetListResi(String list,int start,int end){
        // 查询类别元素
        List<String> listAll = jedis.lrange( list, start, end);
        return listAll;
    }

    public List<String> listGetListResi(String list){
        // 查询所有元素
        List<String> listAll = jedis.lrange( list, 0, -1);
        return listAll;
    }
    //删除一个B元素
    public void listRemoveOneResit(String list ,String node){
        // 删除先进入的B元素
        jedis.lrem(list,1, node);
    }

    //删除所有A元素
    public void listRemoveAllResitTest(String list ,String node){
        // 删除所有A元素
        jedis.lrem(list,0, node);
    }

    @Test
    public void test(){
        this.listPushResit("mylist","a");
        System.out.println(this.listGetListResi("mylist"));
    }

}
