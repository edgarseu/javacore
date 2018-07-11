package guava;

import java.util.function.IntConsumer;

/**
 * Created by Administrator on 2018/4/22.
 */
public class Part3 {
    public static void main(String[] args){
        repeat(10, i -> System.out.println("count:" + i));
    }

    private static void repeat(int n, IntConsumer action){
        for(int i = 0; i < n; i++){
            action.accept(i);
        }
    }
}
