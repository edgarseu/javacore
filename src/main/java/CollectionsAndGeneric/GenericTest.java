package CollectionsAndGeneric;

import entity.Person;

import java.io.File;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author caozy
 * @create 2018/8/28
 */
public class GenericTest {
    public static void main(String[] args) {
/*        List<String> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        System.out.println(l1.getClass() == l2.getClass());*/


        List<Person> people = new ArrayList<>();


        List<Person> personList =new ArrayList<>();
        personList.addAll(people);
        GenericClassAndMethod<Person> genericClassAndMethod = new GenericClassAndMethod<>(new Person(1, "33"));

        genericClassAndMethod.testMethod1(new Integer(1));

        Class clz = genericClassAndMethod.getClass();
        System.out.println(clz);
        Field[] fields = clz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.println(fields[i].getName() + ":" + fields[i].getType().getName());
        }

        List<?>[] lists = new ArrayList<?>[10];

    }
}

class GenericClassAndMethod<T extends Person> {
    T field;

    GenericClassAndMethod(T field) {
        this.field = field;
    }

    public void testMethod(T t) {
        System.out.println(t.getClass().getName());
    }

    public <E> void testMethod1(E e) {
        System.out.println(e.getClass().getName());
    }

    public void testMethod2(Collection<?> collections) {
        collections.size();
    }

    public void testMethod3(Collection<? super Person> collection) {
        collection.add(new SubPerson(122, "22"));
        collection.add(new Person(333, "44"));

        System.out.println(collection.getClass());
        Field[] field = collection.getClass().getDeclaredFields();

        for (int i = 0; i < field.length; i++) {
            System.out.println(field.getClass());
        }
    }


}

class SubPerson extends Person {

    public SubPerson(String name, int age, Timestamp birthday) {
        super(name, age, birthday);
    }

    public SubPerson(int i, String s) {
        super(i, s);
    }
}