package baseAndString;

/**
 * Created by caozy on 2017/6/28.
 */
public class StringCharacter {
    public static void main(String[] args) {


        String t = "hello";
        strTest(t);
        System.out.print(t);
        String string = "h";
        char[] chars = string.toCharArray();
        System.out.println(chars.length);
        String str = string.substring(0, 1);
        String str1 = string.substring(1);
        String testNull = "sdyuuf" + null;
        //str = String.valueOf(null);
        System.out.println(str + "::" + str1);

        str = "1A-WS:TEST1,TEST2;1B-WS";
        strTest(str);
        String[] strings = str.split(";");
        String[] s1;
        for (String s : strings) {
            s1 = s.split(":");
        }
    }

    private static void strTest(String str) {
        str = str + "test";
        return;
    }
}
