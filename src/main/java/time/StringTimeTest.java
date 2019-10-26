package time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author caozy
 * @create 2018/12/28
 */
public class StringTimeTest {
    public static void main(String[] args) {
        String str = "08";
        String str1 = "8";
        Integer integer1 = Integer.valueOf(str);
        Integer integer2 = Integer.valueOf(str1);
        System.out.print("ok");
        String timeStr = "2017-2-09";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            simpleDateFormat.parse(timeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }



    }
}
