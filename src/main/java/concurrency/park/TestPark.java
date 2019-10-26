package concurrency.park;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by Administrator on 2019/4/21.
 */
public class TestPark {
    volatile boolean isPark = false;

    public static void main(String[] args) {
        TestPark testPark = new TestPark();

        Thread chilThread = new Thread() {
            @Override
            public void run() {
                System.out.println("child thread begin park");
                LockSupport.park(testPark);
                System.out.println("child thread end park");
            }
        };

        System.out.println("main thread unpark child thread");
        LockSupport.unpark(chilThread);
    }
}
