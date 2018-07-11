package reference;

import org.junit.Assert;
import org.junit.Test;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @author caozy
 * @create 2018.04.16.19:38
 */
public class WeakReferenceTest {
    @Test
    public void testWeakReference() throws InterruptedException {
        ReferenceQueue queue = new ReferenceQueue();
        WeakReference ref = new WeakReference(new A(), queue);
        Assert.assertNotNull(ref.get());

        Object obj = null;
        obj = queue.poll();
        Assert.assertNull(obj);

        System.gc();

        Thread.sleep(100);
        Assert.assertNull(ref.get());
        obj = queue.poll();
        Assert.assertNotNull(obj);
    }

    @Test
    public void testSoftReference(){
        ReferenceQueue queue = new ReferenceQueue();
        SoftReference ref = new SoftReference(new A(), queue);
        Assert.assertNotNull(ref.get());

        Object obj = null;
        obj = queue.poll();
        Assert.assertNull(obj);

        System.gc();

        Assert.assertNotNull(ref.get());
        obj = queue.poll();
        Assert.assertNull(obj);
    }
}

class A {

}
