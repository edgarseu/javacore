package guava;

import entity.Person;

/**
 * Created by Administrator on 2018/4/21.
 */
public class TestRunnable {
    public static void main(String[] args){
        System.out.println(Thread.currentThread().getId());
        Person person = new Person("000",0 , null);
        prinObjecttMessage(person, 1);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getId() + ":" + person.getName());


    }
    static void printMessage(final String text, final int count){
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getId());
                System.out.print(text + count);
            }
        }).start();
    }

    static void prinObjecttMessage(final Person person, final int count){
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int age = person.getAge();
                age ++;
                person.setName("test");
                System.out.print(Thread.currentThread().getId() + ":" + person.getName());
            }
        }).start();
    }
}

