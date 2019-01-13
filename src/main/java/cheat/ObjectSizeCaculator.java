package cheat;

import entity.Person;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

import java.util.HashMap;

/**
 * @author caozy
 * @create 2018/10/25
 */
public class ObjectSizeCaculator {
    public static void main(String[] args) {
        Integer[] ints = new Integer[]{1,2, 3, 4, 5, 6, 7 };
        System.out.println(VM.current().sizeOf(new HashMap<String, Integer>(1000)));
        System.out.println(VM.current().sizeOf(ints));

        System.out.println(ClassLayout.parseClass(int.class).toPrintable());
        System.out.println(ClassLayout.parseInstance(ints).toPrintable());


//        System.out.println(ClassLayout.parseClass(Person.class).toPrintable());
//        System.out.println(ClassLayout.parseInstance(new Person(1, "1")).toPrintable());
    }
}
