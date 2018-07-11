package IOAndnetworkAndSerializer;

import com.alibaba.fastjson.JSON;
import entity.Person;

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
        String result = JSON.toJSONString(personMap);
        System.out.print(result);
    }
}
