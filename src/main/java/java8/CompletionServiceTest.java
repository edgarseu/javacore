package java8;

import java.util.concurrent.*;

/**
 * @author caozy
 * @create 2018/11/2
 */
public class CompletionServiceTest {
    private static ExecutorService executor = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        CompletionService completionService = new ExecutorCompletionService(executor);
        final int groupNum = 100 / 10;
        for (int i = 1; i <= 10; i++) {
            int start = (i - 1) * groupNum + 1;
            int end = i * groupNum;
            completionService.submit(new Callable() {
                @Override
                public Long call() throws Exception {
                    long sum = 0;
                    for (int j = start; j <= end; j++) {
                        sum += j;
                    }
                    return sum;
                }
            });
        }
        for (int i = 0; i < 10; i++) {
            try {
                long result = (Long) completionService.take().get();
                System.out.println(result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

    }
}
