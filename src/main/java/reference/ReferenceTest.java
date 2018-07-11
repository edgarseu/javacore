/*
package reference;

import org.springframework.util.Assert;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

*/
/**
 * @author caozy
 * @create 2018.04.16.15:54
 *//*

public class ReferenceTest {
    public static void main(String[] args){
*/
/*        A a = new A();
        a.b = new B();
        a = null;
        System.gc();*//*

        testPhantomReference();

    }

    public static void testPhantomReference(){
        ReferenceQueue queue = new ReferenceQueue();
        PhantomReference ref = new PhantomReference(new A(), queue);

        Assert.isNull(ref.get());

        Object obj = null;

        obj = queue.poll();

        Assert.isNull(obj);

// 第一次gc

        System.gc();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.gc();

        Assert.isNull(ref.get());

        obj = queue.poll();

        Assert.isNull(obj);

        A.a = null;

// 第二次gc

        System.gc();

        obj = queue.poll();

        Assert.isNull(obj);
    }
}


*/
/*class A {
    B b;
    public void finalize() {
        System.out.println("method A.finalize at " + System.nanoTime());
    }
}*//*


 class A {
    static A a;
    public void finalize() {
        a = this;
    }
}

class B {
    public void finalize() {
        System.out.println("method B.finalize at " + System.nanoTime());
    }
}*/
