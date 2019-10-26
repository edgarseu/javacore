package concurrency.threadpool;

import java.util.concurrent.*;

/**
 * @author caozy
 * @date 2019/9/5 13:48
 */
public class CoreTimeTest {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = Executors.newCachedThreadPool();

        for (int i = 1; i <= 5; i++) {
            service.execute(new Task(i));
        }

        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                5, 5,
                1, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10, false),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        //threadPool.allowCoreThreadTimeOut(true);  //线程的最大空闲时间，超出这个时间将进行回收
        for (int i = 1; i <= 5; i++) {
            threadPool.execute(new Task(i));
        }

    }
}


class Task implements Runnable {
    private int x;            //线程编号

    public Task(int x) {
        this.x = x;
    }

    public void run() {
        System.out.println(x + " thread doing something!");
        System.out.println("第" + x + "个线程执行完毕");
    }
}