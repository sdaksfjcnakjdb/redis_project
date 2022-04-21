package Thread.Synchronized.Service;

import org.junit.Test;

public class Main {
    @Test
    public  void Ticket() throws InterruptedException{
        Ticket ticket = new Ticket();
        for (int i = 0; i < 9; i++) {
            int num = (int) (Math.random()*10)+1;
            new Thread(    () -> ticket.reduce(num)   ,    "用户"+(i+1)   ).start();
        }
        Thread.sleep(1000l);
    }
    @Test
    public  void notifywait() {
        NotifyWait.Thread1 thread1 = new NotifyWait.Thread1();
        NotifyWait.Thread2 thread2 = new NotifyWait.Thread2();

        thread1.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();
    }
}
