package concurrency;

/**
 * Created by Administrator on 2018/5/5.
 */
public class InterruptRunnableDemo extends Thread {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            // ... 单次循环代码
        }
        System.out.println("done ");
    }
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new InterruptRunnableDemo();
        thread.start();
        Thread.sleep(1000);
        while(true);
        //thread.interrupt();
    }
}