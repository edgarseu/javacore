package CollectionsAndGeneric;

import java.util.Arrays;
import java.util.List;

/**
 * Created by caozy on 2017/12/28.
 */
public class AsListTest {
    public static void main(String[] args) {
        int[] ints = {1,2,3,4,5};
        List list = Arrays.asList(ints);
        System.out.println("list'size：" + list.size());
    }
}
