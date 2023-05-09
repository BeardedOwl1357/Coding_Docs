package datetime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class LocalDateTimeClass {
    public static void main(String[] args) {
        LocalDateTime currentTime = LocalDateTime.now(); // System Time Zone
        System.out.println(currentTime);
        // Converting to UTC
        System.out.println(currentTime.atZone(ZoneId.of("UTC")));
        // To convert to any other zone id, uncomment below code and select timezone
//        ZoneId.getAvailableZoneIds().forEach(System.out::println);
        System.out.println(
                ZoneId.getAvailableZoneIds()
                        .stream()
                        .count()
        );
        // ZonedDateTime
        System.out.println(ZonedDateTime.now());
        System.out.println(ZonedDateTime.now());
    }
}
