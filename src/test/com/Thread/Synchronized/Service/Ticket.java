package Thread.Synchronized.Service;

import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class Ticket  {
    Integer ticknum = 40;
    public  void  reduce(int num){
        Boolean tick = false;

        synchronized (ticknum){
            if (ticknum-num>=0){
                ticknum-=num;
                tick = true;
            }
        }

        if(!tick){
            System.out.println(Thread.currentThread().getName() + "购买__"+num+ "__失败,剩余__"+ticknum+"__");
        }else {
            System.out.println(Thread.currentThread().getName() + "购买__"+num+ "__成功,剩余__"+ticknum+"__");
        }
    }
}
