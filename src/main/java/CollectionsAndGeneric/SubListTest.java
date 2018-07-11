package CollectionsAndGeneric;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caozy on 2017/12/28.
 */
public class SubListTest {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<Integer> ();
        list1.add(1);
        list1.add(2);

        //通过构造函数新建一个包含list1的列表 list2
        List<Integer> list2 = new ArrayList<Integer>(list1);

        //通过subList生成一个与list1一样的列表 list3
        List<Integer> list3 = list1.subList(0, list1.size());

        //修改list3
        list3.add(3);
        //subList 生成子列表后，不要试图去操作原列
        //list1.add(3);   //Exception in thread "main" java.util.ConcurrentModificationException


        System.out.println("list1 == list2：" + list1.equals(list2));
        System.out.println("list1 == list3：" + list1.equals(list3));
    }
}
