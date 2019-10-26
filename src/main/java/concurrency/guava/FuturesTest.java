package concurrency.guava;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.List;
import java.util.concurrent.*;

/**
 * @author caozy
 * @date 2019/10/16 9:39
 */
public class FuturesTest {
    public static void main(String[] args) {
        ListeningExecutorService threadPool =
                MoreExecutors.listeningDecorator(new ThreadPoolExecutor(1, 1,
                        0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>()));


        ListenableFuture<Integer> future1 = threadPool.submit(new Callable<Integer>() {


            @Override
            public Integer call() throws Exception {
                System.out.println("before sleep1");
                Thread.sleep(1000);
                System.out.println("after sleep1");
                return 1;
            }
        });


        ListenableFuture<Integer> future2 = threadPool.submit(new Callable<Integer>() {


            @Override
            public Integer call() throws Exception {
                System.out.println("before sleep2");
                Thread.sleep(2000);
                System.out.println("after sleep2");
                return 2;
            }
        });


        ListenableFuture<Integer> future3 = threadPool.submit(new Callable<Integer>() {


            @Override
            public Integer call() throws Exception {
                System.out.println("before sleep5");
                Thread.sleep(5000);
                System.out.println("after sleep5");
                return 5;
            }
        });
        ListenableFuture<List<Integer>> imFuture = Futures.allAsList(future1, future2, future3);

        try

        {
            List<Integer> result = imFuture.get(3000, TimeUnit.MILLISECONDS);
            int size = result.size();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
