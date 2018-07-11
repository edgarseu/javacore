package IOAndnetworkAndSerializer; /**
 * Created by caozy on 2017/12/26.
 */

import entity.Foo2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class SerialLizer {
    public static void main(String[] args) {

        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
            fos = new FileOutputStream("employee.dat");
            fis = new FileInputStream("employee.dat");
            oos = new ObjectOutputStream(fos);
            ois = new ObjectInputStream(fis);
            Foo2 foo2 = new Foo2();
            oos.writeObject(foo2);
            Foo2 foo21 = (Foo2) ois.readObject();
            System.out.println(foo21);

            fis.close();
            fos.close();
            oos.close();
            ois.close();
        } catch (Exception ex) {

        } finally {

        }
    }
}
