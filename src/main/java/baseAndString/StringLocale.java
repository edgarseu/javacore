package baseAndString; /**
 * Created by caozy on 2017/12/25.
 */
import java.util.Locale;

public class StringLocale {
    public static void main(String[] args) {
        String lower_abcdefg = "abcdefghijklmnopqrstuvwxyz";
        String upper_abcdefg = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        Locale[] locales = Locale.getAvailableLocales();
        for (Locale locale : locales) {
            System.out.print(locale.toString() + "\t");

            if (lower_abcdefg.toUpperCase(locale).equals(upper_abcdefg)) {
                System.out.println("match");
            } else {
                System.out.println("not match");
            }
        }
    }

}
