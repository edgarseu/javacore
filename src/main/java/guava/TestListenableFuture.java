package guava;

import com.google.common.util.concurrent.*;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

public class TestListenableFuture {
    // 创建线程池
    final static ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());

    public static void main(String[] args) throws Exception {
        Long t1 = System.currentTimeMillis();
        // 任务1
        ListenableFuture<Boolean> booleanTask = service.submit(new Callable<Boolean>() {
            public Boolean call() throws Exception {
                return true;
            }
        });

        Futures.addCallback(booleanTask, new FutureCallback<Boolean>() {
            public void onSuccess(Boolean result) {
                System.err.println("BooleanTask: " + result);
            }

            public void onFailure(Throwable t) {
            }
        });

        // 任务2
        ListenableFuture<String> stringTask = service.submit(new Callable<String>() {
            public String call() throws Exception {
                return "Hello World";
            }
        });

        Futures.addCallback(stringTask, new FutureCallback<String>() {
            public void onSuccess(String result) {
                System.err.println("StringTask: " + result);
            }

            public void onFailure(Throwable t) {
            }
        });

        // 任务3
        ListenableFuture<Integer> integerTask = service.submit(new Callable<Integer>() {
            public Integer call() throws Exception {
                return new Random().nextInt(100);
            }
        });

        Futures.addCallback(integerTask, new FutureCallback<Integer>() {
            public void onSuccess(Integer result) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.err.println("IntegerTask: " + result);
            }

            public void onFailure(Throwable t) {
            }
        });

        // 执行时间
        System.err.println("time: " + (System.currentTimeMillis() - t1));
    }

}
