package Callendar;

import java.time.ZoneId;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import static java.util.Calendar.*;

public class CalendarSample {
    public static void main(String[] args) {
        Calendar calendar = new Calendar.Builder()
                .set(YEAR, 2014)
                .set(MONTH, FEBRUARY)
                .set(DATE, 28)
                .set(HOUR, 16)
                .set(MINUTE, 22)
                .setTimeZone(TimeZone.getTimeZone(ZoneId.systemDefault()))
                .setLocale(Locale.ENGLISH)
                .build();

        System.out.println(calendar.toInstant().toString());

    }
}
