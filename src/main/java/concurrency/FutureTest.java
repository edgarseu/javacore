package concurrency;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by caozy on 2018/2/11.
 */
public class FutureTest {
    public static void main(String[] args) {
        //创建实现了Callable接口的对象
        MyCallable callable = new MyCallable();
        //创建用于处理任务的线程池
        ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        //将任务添加到线程池中并且获得返回的FutureTask对象
        System.out.println("提交任务的时间: " + getNowTime());
        FutureTask<String> task = (FutureTask<String>) threadPool.submit(callable);

        //获取到call方法的返回值
        try {
            String result = task.get();
            System.out.println("得到返回值: " + result);
            System.out.println("结束执行get的时间: " + getNowTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getNowTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date());
    }

}

class MyCallable implements Callable<String> {

    public String call() throws Exception {
        Thread.sleep(3000);
        return "call method result";
    }
}
