package guava;

import java.math.BigInteger;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2018/4/21.
 */
public class CreatStream {
    public static void main(String[] args){
        //创建stream 0
        Stream<Integer> integerStream1 = Stream.of(1,2,4,5);
       // integerStream1.forEach(System.out ::println);

        Stream<String> stringStream0 = Stream.of("taobao");
        //1
        Stream.generate(new Supplier<Double>() {
            @Override
            public Double get(){
                return Math.random();
            }
        }).forEach(System.out :: println);

        Stream<BigInteger> integerStream = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));
        //ntegerStream.limit(100).forEach(System.out :: println);
    }
}
