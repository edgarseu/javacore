package concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

/**
 * Created by Administrator on 2018/7/28.
 */
public class TimingThreadPool extends ThreadPoolExecutor {

    public TimingThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    private ThreadLocal<Long> startTime = new ThreadLocal<>();
    private AtomicLong numtask = new AtomicLong();
    private AtomicLong totalTime = new AtomicLong();
    private Logger logger = Logger.getLogger("TimingPool");

    @Override
    protected void beforeExecute(Thread thread, Runnable r) {
        super.beforeExecute(thread, r);
        startTime.set(System.nanoTime());
        logger.fine(String.format("Thread:%s,run:%s", thread, r));
    }
}
