package concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @author caozy
 * @create 2018/10/31
 */
public class VideoConference implements Runnable {
    private final CountDownLatch controller;

    public VideoConference (int number){
        controller = new CountDownLatch(number);
    }

    public void arrive(String name){
        System.out.printf("%s has arrived.\n", name);
        controller.countDown();
        System.out.printf("VideoConference:waiting for %d participants.\n", controller.getCount());
    }

    @Override
    public void run() {
            System.out.printf("VideoConference: Initialization : %d participants. \n", controller.getCount());
        try {
            controller.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("VideoConference: All the participants have come.\n Let's start...\n");

    }
}
