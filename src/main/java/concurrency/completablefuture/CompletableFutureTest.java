package concurrency.completablefuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * @author caozy
 * @date 2019/10/21 15:08
 */
public class CompletableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
/*        final CompletableFuture<Integer> future = CompletableFuture
                .supplyAsync(() -> doSomethingAndReturnA())
                .thenApply(a -> convertToB(a));

        future.get();*/

/*        final CompletableFuture<Integer> future = CompletableFuture
                .supplyAsync(() -> {
                    String s = doSomethingAndReturnA();
                    return convertToB(s);
                });

        future.get();*/

        final CompletableFuture<String> future1 = CompletableFuture
                .supplyAsync(() -> {return doSomethingAndReturnA();});

        final CompletableFuture<String> future2 = CompletableFuture
                .supplyAsync(() -> {return doSomethingAndReturnA2();});
    }

    static void completedFutureExample() {
        CompletableFuture<String> cf = CompletableFuture.completedFuture("message");
        assertTrue(cf.isDone());
        assertEquals("message", cf.getNow(null));
    }

    static void runAsyncExample() {
        CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> {
            assertTrue(Thread.currentThread().isDaemon());
            randomSleep();
        });
        assertFalse(cf.isDone());
        assertTrue(cf.isDone());
    }

    static void randomSleep() {
        try {
            Thread.sleep(new Random().nextLong());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static int convertToB(final String a) {
        System.out.println("convertToB: " + Thread.currentThread().getName());
        return Integer.parseInt(a);
    }

    private static String doSomethingAndReturnA() {
        System.out.println("doSomethingAndReturnA: " + Thread.currentThread().getName());


        return "1";
    }


    private static String doSomethingAndReturnA2() {
        System.out.println("doSomethingAndReturnA: " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "1";
    }
}
