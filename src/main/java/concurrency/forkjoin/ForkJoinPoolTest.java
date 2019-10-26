package concurrency.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author caozy
 * @date 2019/10/25 15:03
 */
public class ForkJoinPoolTest {

    private final static List<Integer> sender = new ArrayList<Integer>(21000000);

    private final static List<Integer> receiver = new ArrayList<>(21000000);
    private final static List<Integer> receiver2 = new ArrayList<>(21000000);

    private final static AtomicInteger i = new AtomicInteger(0);

    static {
        log("prepare data");
        while (i.get() < 21000000) {
            sender.add(i.get());
            i.incrementAndGet();
        }
        log("prepare over");
    }


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int count = 5000000;
        SumTask sumTask = new SumTask(0, count);
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        ForkJoinTask<Integer> submit = forkJoinPool.submit(sumTask);
        System.out.println(submit.get());
        int s = 0;
        for (int i = 0; i <= count; i++) {
            s += i;
        }
        System.out.println(s);
    }

    public static class SumTask extends RecursiveTask<Integer> {

        private final static int threshold = 5000;

        private int start;

        private int end;

        private SumTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        /**
         * The main computation performed by this task.
         *
         * @return the result of the computation
         */
        @Override
        protected Integer compute() {
            int sum = 0;
            if (end - start < threshold) {
                for (int i = start; i < end; i++) {
                    sum += i;
                }
            } else {
                int middle = (start + end) / 2;
                SumTask sumTask = new SumTask(start, middle);
                SumTask sumTask1 = new SumTask(middle, end);
                SumTask.invokeAll(sumTask, sumTask1);
                sum = sumTask.join() + sumTask1.join();
            }
            return sum;
        }
    }

    private static void log(String log) {
        System.out.println(log);
    }
}