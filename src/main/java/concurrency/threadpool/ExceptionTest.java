package concurrency.threadpool;

import java.util.concurrent.*;

/**
 * @author caozy
 * @date 2019/9/5 15:09
 */
public class ExceptionTest {
    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(1);

        for (int i = 1; i <= 5; i++) {
            //service.submit(new ExceptionTask(i));
        }

        final Thread.UncaughtExceptionHandler exceptionHandler = new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                synchronized (this) {
                    System.err.println("Uncaught exception in thread '" + t.getName() + "': " + e.getMessage());
                }
            }
        };
        // 自定义线程的newThread方法以加入自己的Handler
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                System.out.println("creating pooled thread");
                final Thread thread = new Thread(r);
                //以为这样可以抓住执行过程的异常
                thread.setUncaughtExceptionHandler(exceptionHandler);
                return thread;
            }
        };
        ExecutorService threadPool
                = Executors.newFixedThreadPool(1, threadFactory);
        Callable callable = new Callable() {
            @Override
            public Integer call() throws Exception {
                throw new Exception("Error in Callable");
            }
        };
        threadPool.submit(callable);
        threadPool.shutdown();
        System.out.println("-----------Done.---------");

    }
}

class ExceptionTask implements Runnable {
    private int x;            //线程编号

    public ExceptionTask(int x) {
        this.x = x;
    }

    public void run() {
        System.out.println("第" + x + "个线程开始执行");
        int i = 3/0;
        System.out.println(x + " thread doing something!");
        System.out.println("第" + x + "个线程执行完毕");
    }
}
