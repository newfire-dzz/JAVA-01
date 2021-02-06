package concurrent;

import java.util.concurrent.Semaphore;

public class Semphere06 {

    public static int num;

    public static void main(String[] args) {

        //使用Semaphore
        Semaphore semaphore = new Semaphore(0);
        new Thread(() -> {
            num = method();
            semaphore.release();
        }).start();

        try {
            semaphore.acquire();
            System.out.println("子线程的值：" + num);
            System.out.println("当前线程：" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static int method(){
        return 6;
    }
}
