package stringformattingoperations;

public class Basic {
    public static void main(String[] args) {
        // Implementing the stuff which I have put on readme.md
        // Showing Positive and negative numbers
        // Using String.format() or System.out.printf() is equivalent
        System.out.printf("%+d \n",5);
        System.out.printf("%+d \n",-5);
        System.out.printf("%(d \n",-5);

        // Showing float decimal points
        System.out.printf("%.3f \n",15654.494984); // Rounds off to 3 places

        // According to number systems (it is better to use NumberFormat class)
        System.out.printf("%,d \n",167984566); // International Numbering System

        // Parameter Index
        System.out.printf(
                "%2$s %1$s %3$s \n",
                "Sir", // 1st parameter
                "Night", // 2nd parameter
                "Eye" // 3rd parameter
                );
    }
}
