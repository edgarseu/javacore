package concurrency;

/**
 * @author caozy
 * @create 2018.04.17.11:11
 * JAVA线程本地存储之ThreadLocal的分析  http://bolinyang.iteye.com/blog/1870125
 */

class LocalObject {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class LocalStoreThread extends Thread {
    /** 定义了一个线程本地存储的成员变量 **/
    private ThreadLocal<LocalObject> threadLocal = new ThreadLocal<LocalObject>();

    public LocalStoreThread(LocalObject lo) {
        // set之前打印当前线程
        System.out.println(Thread.currentThread().getName());   // main
        threadLocal.set(lo);
    }

    @Override
    public void run() {
        // get之前打印当前线程
        System.out.println(Thread.currentThread().getName()); // Thread-0
        System.out.println(threadLocal.get().getName());
    }
}

/**
 * <pre>
 * 创建一个线程实例，这个线程实例中有一个线程本地存储成员变量
 * </pre>
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        LocalObject lo = new LocalObject();
        lo.setName("thread-local");
        new LocalStoreThread(lo).start();
    }
}
