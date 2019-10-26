package IOAndnetworkAndSerializer;

import com.google.gson.Gson;
import entity.Person;
import reflect.PeopleMgr;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author caozy
 * @create 2018/7/6
 */
public class JsonTest {
    public static void main(String[] args) {
        Map<String, List<Person>> personMap = new HashMap<>();
        Person person = new Person("01", 12, new Timestamp(System.nanoTime()));
        Person person1 = new Person("02", 13, new Timestamp(System.nanoTime()));
        List<Person> people = new ArrayList<>();
        people.add(person);
        people.add(person1);

        personMap.put("test", people);
        personMap.put("test2", people);

        PeopleMgr peopleMgr = new PeopleMgr();

        peopleMgr.add(new Person(1, "1"));
        peopleMgr.add(new Person(2, "2"));

        String json = null;
        Object object = null;
        try {
            json = Gson.class.newInstance().toJson(peopleMgr);
            object = Gson.class.newInstance().fromJson(json, PeopleMgr.class);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            String result = field.toString();
            System.out.println(result);
        }
    }
}
