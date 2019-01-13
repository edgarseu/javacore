package reflect;

import entity.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author caozy
 * @create 2018/11/1
 */
public class PeopleMgr {
    private Map<String, List<Person>> all = new HashMap<>();

    public void add(Person person) {
        if (all.containsKey(person.getName())) {
            all.get(person.getName()).add(person);
            return;
        }
        all.put(person.getName(), new ArrayList<>());
        all.get(person.getName()).add(person);
    }
}
