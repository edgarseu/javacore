package java8;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionService;
import java.util.stream.Collectors;

/**
 * @author caozy
 * @create 2018/11/2
 */
public class MethodReference {
    public static void main(String[] args){
        Map<String, String> map = new HashMap<>();
        map.put("alpha", "X");
        map.put("bravo", "Y");
        map.put("charlie","Z" );
        String str = "alpha-bravo-charlie";
        map.replaceAll(str::replace);
        System.out.println(map.toString());

        List<String> words = new ArrayList<String>();
        words.add("hello");
        words.add("word");

        //将words数组中的元素再按照字符拆分，然后字符去重，最终达到["h", "e", "l", "o", "w", "r", "d"]
        //如果使用map，是达不到直接转化成List<String>的结果
        List<String> stringList = words.stream()
                .flatMap(word -> Arrays.stream(word.split("")))
                .distinct()
                .collect(Collectors.toList());
        stringList.forEach(e -> System.out.println(e));

    }
}
