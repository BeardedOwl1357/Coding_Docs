package datetime;
import java.time.LocalDate;
import java.time.Month; // Enum which makes it easier to include months
import java.time.LocalDateTime;
public class LocalDateClass {
    public static void main(String[] args) {
        System.out.println(LocalDate.now()); // Returns current date according to local timezone
/*{
	"x-user-persona": [
		"ABCD",
		"EFGH",
		"IJKL"
	]
}*/
        /* Creating a custom date object
            * The date format is Year-Month-Day
            * We use the LocalDate.of(int year, java.time.Month, int day) method
                * java.time.Month is an enum class. It contains enum for each month in calendar
         */
        LocalDate date1 = LocalDate.of(2025, Month.APRIL, 15);
        System.out.println(date1); // Creates a LocalDate object
        System.out.println("------------------------");

        /* Extracting Day of week, Month and Year from a given date object
            * getDayOfWeek() -> what day it is LocalDate object (example, Tuesday)
            * getDayOfMonth() -> what day in month it is in LocalDate object (example, 15th day in a month of 31 days)
            * getDayOfYear() ->  what day in year it is in LocalDate object (215th day)
            * lengthOfMonth() -> Length of the month in the LocalDate object
            * lengthOfYear() -> Length of year in the LocalDate object
            * getYear() -> Gets the year from LocalDate object
            * getMonth() -> Gets the Month from LocalDate object
         */
        System.out.println("Day at date " + date1 + " = " + date1.getDayOfWeek());
        System.out.println(date1.getDayOfMonth() + " Days out of " + date1.lengthOfMonth() + " Days");
        System.out.println(date1.getDayOfYear() + " Days out of " + date1.lengthOfYear() + " Days");
        System.out.println("Is the year " + date1.getYear() + " leap = " + date1.isLeapYear());
        System.out.println("------------------------");
    }
}
