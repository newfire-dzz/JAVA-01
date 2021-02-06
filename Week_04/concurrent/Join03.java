package concurrent;

public class Join03 {

    public static int num;

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> num = method());
        thread.start();

        //使用Join等待
        thread.join();

        System.out.println("子线程的值：" + num);
        System.out.println("当前线程：" + Thread.currentThread().getName());
    }

    public static int method(){
        return 3;
    }

}
