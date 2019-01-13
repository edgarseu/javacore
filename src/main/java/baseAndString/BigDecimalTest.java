package baseAndString;

import java.math.BigDecimal;

/**
 * @author caozy
 * @create 2018/9/12
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal(10);
        BigDecimal bigDecimal1 = new BigDecimal(3);
        BigDecimal result = bigDecimal.divide(bigDecimal1);
        System.out.println(result);
    }
}
