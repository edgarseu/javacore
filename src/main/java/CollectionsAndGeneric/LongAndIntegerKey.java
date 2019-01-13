package CollectionsAndGeneric;

import entity.Person;

import java.util.HashMap;
import java.util.Map;

/**
 * @author caozy
 * @create 2018/9/6
 */
public class LongAndIntegerKey {
    public static void main(String[] args) {
        Map<Long, Person> map = new HashMap<>();
        map.put(new Long(12354634), new Person(1, "2"));
        int i = 12354634;
        Integer I = (Integer) i;

        System.out.println("I:"+I.hashCode() + "LongI:"+ new Long(1).hashCode());
        Person person = map.get(new Long(i));
    }
}
