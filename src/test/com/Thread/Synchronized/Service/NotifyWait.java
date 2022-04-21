package Thread.Synchronized.Service;

import org.junit.Test;

//以下代码来自参考文章
public class NotifyWait {
    public static Object object = new Object();

    static class Thread1 extends Thread{
        @Override
        public void run() {
            System.out.println(1);
            synchronized (object) {
                try {
                    System.out.println("wait");
                    object.wait();
                } catch (InterruptedException e) {
                }
                System.out.println("线程"+Thread.currentThread().getName()+"获取到了锁");
            }
            System.out.println("线程"+Thread.currentThread().getName()+"释放了锁");
        }
    }

    static class Thread2 extends Thread{
        @Override
        public void run() {
            System.out.println(2);
            synchronized (object) {
                try {
                    System.out.println("notify");
                    object.notify();
                }catch (Exception e){

                }
                System.out.println("线程"+Thread.currentThread().getName()+"调用了object.notify()");
            }
            System.out.println("线程"+Thread.currentThread().getName()+"释放了锁");
        }
    }

    @Test
    public  void notifywait() {
        NotifyWait.Thread1 thread1 = new NotifyWait.Thread1();
        NotifyWait.Thread2 thread2 = new NotifyWait.Thread2();

        thread1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread2.start();
    }
}
