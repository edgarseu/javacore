package guava;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Administrator on 2018/4/21.
 */
public class TestListForeach {
    public static void main(String[] args){
        List<String> list  = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.forEach(System.out :: println);

        Comparator.comparing(String :: length);
    }
}
