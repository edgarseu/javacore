package entity;

import java.sql.Timestamp;

/**
 * @author caozy
 * @create 2018/7/6
 */
public class Person {
    private String name;
    private int age;
    private Timestamp birthday;

    public Person(String name, int age, Timestamp birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public Person(int i, String s) {
        this.age = i;
        this.name = s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }
}
