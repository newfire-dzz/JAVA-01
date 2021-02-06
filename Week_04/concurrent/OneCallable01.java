package concurrent;

import java.util.concurrent.Callable;

public class OneCallable01 {

    public static void main(String[] args) throws Exception {

        Integer num = ((Callable<Integer>) () -> method()).call();

        System.out.println("子线程的值：" + num);
        System.out.println("当前线程：" + Thread.currentThread().getName());
    }

    public static int method(){
        return 1;
    }
}
