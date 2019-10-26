package time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * https://www.baeldung.com/java-zone-offset
 *
 * @author caozy
 * @create 2019/7/17
 */
public class ZoneIDTest {
    public static void main(String[] args) {
        //LocalDateTime now = LocalDateTime.now();

        // winter offset +01:00
        LocalDateTime winterNow = LocalDateTime.parse("2019-12-12T10:15:30", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        // summer offset +02:00
        LocalDateTime summerNow = LocalDateTime.parse("2019-07-12T10:15:30", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        ZoneId zone = ZoneId.of("Europe/Berlin");

        ZoneId gmtZone = ZoneId.of("GMT+08:00");

        ZoneOffset winterOffSet = zone.getRules().getOffset(winterNow);

        ZoneOffset summerOffSet = zone.getRules().getOffset(summerNow);
    }
}
