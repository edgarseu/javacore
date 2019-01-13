package reference;

import entity.Person;

/**
 * @author caozy
 * @create 2018/8/21
 */
public class PassParameter {
    public static void main(String[] args) {
        Person person = new Person(000, "");
        String t = "test";
        passString(t);

        passReference(person);

        passReferenceAndReturnNew(person);

        passReferenceAndReturnNew();

    }

    private static String passString(String str) {
        str = str + "passString";
        return str;
    }

    private static Person passReference(Person person) {
        person.setName(person.getName() + "passReference");
        return person;
    }

    private static Person passReferenceAndReturnNew(Person person) {
        person = new Person(110, "passReferenceAndReturnNew");
        return person;
    }

    private static Person passReferenceAndReturnNew() {
        Person person = new Person(110, "passReferenceAndReturnNew");
        return person;
    }
}
