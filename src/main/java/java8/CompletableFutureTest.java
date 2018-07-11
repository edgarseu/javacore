package java8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by Administrator on 2018/5/1.
 */
public class CompletableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
       /* System.out.println(Thread.currentThread().getId());
        CompletableFuture completableFuture = CompletableFuture.supplyAsync(() -> {
           System.out.println(Thread.currentThread().getId());
            int i = 1/0;
            return 100;
        });

        *//*completableFuture.join();*//*
        try {
            completableFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/
/*
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            return 100;
        });
        CompletableFuture<Void> f =  future.thenAcceptBoth(CompletableFuture.completedFuture(10), (x, y) -> System.out.println(x * y));
        System.out.println(f.get());*/

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
/*            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/

            return 100;
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "abc";
        });
        CompletableFuture<String> f =  future.thenCombine(future2, (x,y) -> y + "-" + x);
        System.out.println(f.get());
    }
}
