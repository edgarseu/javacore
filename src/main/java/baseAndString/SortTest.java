package baseAndString;

/**
 * @author caozy
 * @create 2018/10/9
 */

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by l_l on 2018/7/3.
 */
public class SortTest {

    public static void main(String[] args) {
        testSort();
        //testSort1();
    }

    public static void testSort() {
        List<Integer> results = Lists.newArrayList();
        for (int i = 0; i < 500; i++) {
            results.add((int) (Math.random() * 10));
        }
        System.out.println(results);
        //        System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
        Collections.sort(results, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 == o2) {
                    return 0;
                }
                return o1 > o2 ? 1 : -1;
                //                return Integer.compare(o1, o2);
            }
        });
        System.out.println(results);
    }

    public static void testSort1() {
        List<Integer> results = Lists.newArrayList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 1, 0, -2, 0, 0, 0, 0);
        results = Lists.newArrayList(1, 3, 5, 4, 6576, 7, null, 0);
        System.out.println(results);

        Collections.sort(results, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 == o2) {
                    return 0;
                }
                if (o1 == null) {
                    return 1;
                }
                if (o2 == null) {
                    return -1;
                }
                return o1 > o2 ? 1 : -1;
            }
        });
        System.out.println(results);
    }
}