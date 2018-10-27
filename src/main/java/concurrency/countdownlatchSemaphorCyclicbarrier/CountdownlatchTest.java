package concurrency.countdownlatchSemaphorCyclicbarrier;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Administrator on 2018/7/14.
 */
public class CountdownlatchTest {
    public static void main(String[] args) {
        startGroupThread();
    }

    // 主线程同时启动一组线程
    private static void startGroupThread() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < 3; i++) {
            CountDownHandle countDownHandle = new CountDownHandle(String.valueOf(i), countDownLatch);
            countDownHandle.start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        countDownLatch.countDown();
        System.out.println("启动一组线程");
    }
}

class CountDownHandle extends Thread {
    CountDownLatch countDownLatcht;

    CountDownHandle(String name, CountDownLatch countDownLatch) {
        super(name);
        this.countDownLatcht = countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println("thread：" + getName() + "准备启动");
            this.countDownLatcht.await();
            System.out.println("thread：" + getName() + "完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
