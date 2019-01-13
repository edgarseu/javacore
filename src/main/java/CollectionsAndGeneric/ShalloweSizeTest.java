package CollectionsAndGeneric;

import entity.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * @author caozy
 * @create 2018/10/25
 * -Xmx1024m -Xms1024m -Xss256k -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=256m -XX:SoftRefLRUPolicyMSPerMB=0 -XX:MaxGCPauseMillis=200 -XX:+UseG1GC -XX:+PrintTenuringDistribution -XX:+PrintHeapAtGC -XX:+PrintGC -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+HeapDumpOnOutOfMemoryError
 * //-XX:+UnlockDiagnosticVMOptions  -XX:+G1PrintHeapRegions
 */
public class ShalloweSizeTest {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        while (true) {
            people.add(new Person(12, "test"));
        }
    }
}
