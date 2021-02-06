package concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFuture02 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //使用CompletableFuture
        Integer num = CompletableFuture.supplyAsync(() -> method()).get();

        System.out.println("子线程的值：" + num);
        System.out.println("当前线程：" + Thread.currentThread().getName());
    }

    public static int method(){
        return 2;
    }
}
