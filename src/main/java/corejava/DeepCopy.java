package corejava;

import com.ctrip.infosec.WordMask.MaskHelper;

import java.io.*;

/**
 * Created by caozy on 2017/7/29.
 */
public class DeepCopy {
    public static void main(String[] args){
        String value = "13764663549";
        String result = MaskHelper.maskMobile(value);
        System.out.println(result);
        Person p = new Person();
        p.name = "akdk";
        Person p1 = deepClone(p);
        boolean e = p1.name == p.name;

    }
    public  static  <T> T  deepClone(T o)
    {
        ObjectInputStream oi =null;
        T copy = null;
        try {
            //将对象写到流里
            ByteArrayOutputStream bo=new ByteArrayOutputStream();
            ObjectOutputStream oo = new ObjectOutputStream(bo);
            oo.writeObject(o);
            //从流里读出来
            ByteArrayInputStream bi=new ByteArrayInputStream(bo.toByteArray());
            oi=new ObjectInputStream(bi);
            copy = (T) oi.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return copy;
    }

}
class Person implements  Serializable{
    String name;
}
