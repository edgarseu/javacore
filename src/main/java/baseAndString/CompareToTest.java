package baseAndString;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by caozy on 2018/1/2.
 */
public class CompareToTest {
    public static void main(String[] args){
        BigDecimal bg1 = new BigDecimal("1.0");
        BigDecimal bg2 = new BigDecimal("1.00");
        int compare = bg1.compareTo(bg2);
        boolean equal = bg2.equals(bg1);

    }
}
