package time;

import org.joda.time.LocalDate;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author caozy
 * @create 2018/5/11
 */
public class TimeTest {
    public static void main(String[] args) {

        Calendar calendarAdd = Calendar.getInstance();
        calendarAdd.add(Calendar.DAY_OF_WEEK, 21);

        final Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        final Calendar calendar = Calendar.getInstance();

        final Instant instant = Instant.now();
        final LocalDateTime localDateTime = LocalDateTime.now();
        final ZonedDateTime zonedDateTime = ZonedDateTime.now();


        //Date转Instant
        Instant dateInstant = date.toInstant();
        //Timestamp转Instant
        Instant timestampInstant = timestamp.toInstant();
        //Calendar转Instant
        Instant calendarInstant = calendar.toInstant();
        //LocalDateTime转Instant
        Instant localDateTimeInstant = localDateTime.toInstant(ZoneOffset.of(ZoneId.systemDefault().getId()));
        //ZonedDateTime转Instant
        Instant zonedDateTimeInstant = zonedDateTime.toInstant();


        //Date转LocalDateTime
        LocalDateTime dateLocalDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        //Timestamp转LocalDateTime
        LocalDateTime timestampLocalDateTime = timestamp.toLocalDateTime();
        //Calendar转LocalDateTime
        LocalDateTime calendarLocalDateTime = LocalDateTime.ofInstant(calendar.toInstant(), ZoneOffset.systemDefault());
        //Instant转LocalDateTime
        LocalDateTime instantLocalDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        //ZonedDateTime转LocalDateTime
        LocalDateTime zonedDateTimeLocalDateTime = zonedDateTime.toLocalDateTime();


        //Date转ZonedDateTime
        ZonedDateTime dateZonedDateTime = ZonedDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        //Timestamp转ZonedDateTime
        ZonedDateTime timestampZonedDateTime = ZonedDateTime.ofInstant(timestamp.toInstant(), ZoneId.systemDefault());
        //Calendar转ZonedDateTime
        ZonedDateTime calendarZonedDateTime = ZonedDateTime.ofInstant(calendar.toInstant(), ZoneId.systemDefault());
        //Instant转ZonedDateTime
        ZonedDateTime instantZonedDateTime = instant.atZone(ZoneId.systemDefault());
        //LocalDateTime转ZonedDateTime
        ZonedDateTime localDateTimeZonedDateTime = localDateTime.atZone(ZoneId.systemDefault());

//Date转Timestamp
        Timestamp dateTimestamp = new Timestamp(date.getTime());
        //Calendar转Timestamp
        Timestamp calendarTimestamp = new Timestamp(calendar.getTimeInMillis());
        //Instant转Timestamp
        Timestamp instantTimestamp = Timestamp.from(instant);
        //LocalDateTime转Timestamp
        Timestamp localDateTimeTimestamp = Timestamp.valueOf(localDateTime);
        //ZonedDateTime转Timestamp
        Timestamp zonedDateTimeTimestamp = Timestamp.from(zonedDateTime.toInstant());

        //Date转Calendar
        Calendar dateCalendar = Calendar.getInstance();
        dateCalendar.setTime(date);
        //Timestamp转Calendar
        Calendar timestampCalendar = Calendar.getInstance();
        timestampCalendar.setTimeInMillis(timestamp.getTime());
        //Instant转Calendar
        Calendar instantCalendar = GregorianCalendar.from(ZonedDateTime.ofInstant(instant, ZoneId.systemDefault()));
        //LocalDateTime转Calendar
        Calendar localDateTimeCalendar = GregorianCalendar.from(ZonedDateTime.of(localDateTime, ZoneId.systemDefault()));
        //ZonedDateTime转Calendar
        Calendar zonedDateTimeInstantCalendar = GregorianCalendar.from(zonedDateTime);

        LocalDate now = LocalDate.now();
        int day = now.getDayOfWeek();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmm");

        LocalTime time = LocalTime.parse("1300",formatter);

    }

    public static LocalDateTime convertToLocalDateTime(Calendar calendar){
        if(calendar == null){
            return null;
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
        String calendarStr = simpleDateFormat.format(calendar.getTime());

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(calendarStr, df);

    }
}
