package concurrency.JoinWaitTest;

/**
 * Created by Administrator on 2018/7/21.
 */
public class JoinWaitTest {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread1");
            }
        });


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(1000);
                    System.out.println("join");
                    thread1.join();
//                    thread1.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread2");
            }
        });

        thread2.start();
        thread1.start();
        synchronized (thread1){
            try {
                thread1.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("syn");
        }

    }
}
