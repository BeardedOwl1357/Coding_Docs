package datetime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

public class InstantClass {
    public static void main(String[] args) {
        // Printing current time instant
        System.out.println(Instant.now());
        // Getting DateTime in Local Timezone from an Instant object
        System.out.println(LocalDateTime.ofInstant(Instant.now(),ZoneId.systemDefault()));
        // Max Time supported = +1000000000-12-31T23:59:59.999999999Z (Cannot be cased to LocalDateTime.ofInstant()
        System.out.println(Instant.MAX);
        // Min Time supported = -1000000000-01-01T00:00:00Z
        System.out.println(Instant.MIN);
        /* Arithmetic Via ChronoUnit */
        Instant abhi = Instant.now();
        System.out.println("Original Value = " + abhi +
                "\n" + LocalDateTime.ofInstant(abhi,ZoneId.of("UTC"))
        )
        ;
        // Addition
        /* ChronoUnit
            * https://docs.oracle.com/javase/8/docs/api/java/time/temporal/ChronoUnit.html
            * SECONDS
            * MINUTES
            * HOURS
            * HALF_DAYS
            * DAYS
            * WEEKS
            * MONTHS
            * YEARS
            * DECADES
            * CENTURIES
         */
        System.out.println("Adding one second \t " + abhi.plus(1,ChronoUnit.SECONDS));
        System.out.println("Adding one minute \t " + abhi.plus(1,ChronoUnit.MINUTES));
        System.out.println("Adding a half day \t " + abhi.plus(1,ChronoUnit.HALF_DAYS));
        System.out.println("Adding two days \t " + abhi.plus(2,ChronoUnit.DAYS));
        // Instant.plus() gives an UnsupportedTemporalTypeException for month and beyond.
        // Convert to LocalDateTime, perform operation and then convert back to Instant
        System.out.println(
                "Adding one month \t " +
                LocalDateTime.ofInstant(abhi,ZoneId.of("UTC"))
                        .plus(1,ChronoUnit.MONTHS)
                        .toInstant(ZoneOffset.UTC)
        );
    }
}
