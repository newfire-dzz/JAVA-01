package concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo04 {

    private static int num;

    public static void main(String[] args) throws InterruptedException {

        //使用CountDownLatch
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(() -> {
            num = method();
            countDownLatch.countDown();
        }).start();

        countDownLatch.await();

        System.out.println("子线程的值：" + num);
        System.out.println("当前线程：" + Thread.currentThread().getName());
    }

    public static int method(){
        return 4;
    }

}

