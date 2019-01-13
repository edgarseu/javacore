package reflect;

import com.ctrip.flight.xapi.common.SerializationUtil;
import com.google.gson.Gson;
import entity.Person;

import java.lang.reflect.Field;

/**
 * @author caozy
 * @create 2018/9/20
 */
public class ReflectTest {
    public static void main(String[] args) {
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
