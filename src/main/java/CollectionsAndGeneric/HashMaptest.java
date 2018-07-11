package CollectionsAndGeneric;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by caozy on 2017/9/30.
 */
public class HashMaptest {
    public static void main(String[] args){
            testjoin();
    }
    private static void testjoin(){
        Set<String> stringSet = new LinkedHashSet<String>();
        stringSet.add("a");
        stringSet.add("c");
        stringSet.add("b");
        String str = StringUtils.join(stringSet.toArray(),",");
        System.out.println(str);
    }
    private static void setpara(int m){
        System.out.println(m);
    }
    private static void testInteger(Integer m){
        System.out.println(m);
    }
}
