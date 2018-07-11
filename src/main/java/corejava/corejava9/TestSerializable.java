package corejava.corejava9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * Created by caozy on 2017/6/30.
 */
public class TestSerializable {
    public void serialize(String fileName, Person person){
        try {
            FileOutputStream fout = new FileOutputStream(fileName);
            ObjectOutputStream objectOut = new ObjectOutputStream(fout);
            fout.close();
            objectOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void  main(String[] args) throws FileNotFoundException {
        try {
            FileOutputStream fout = new FileOutputStream(new File("serialize.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {

        }

    }
}
