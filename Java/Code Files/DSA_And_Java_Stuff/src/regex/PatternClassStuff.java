package regex;
import java.util.regex.Pattern;
public class PatternClassStuff {
    public static void main(String[] args) {
        String input = "aaaaaaaaaaaaBcasbaaaaaaaaad";
        String regex_expr = "a+.*"; // Contains one or more than one "a" and then anything is allowed
        // Creating an object which utilises regular expression
        Pattern pattern = Pattern.compile(regex_expr);

        // Directly checking whether any one instance of regex is satisfied once or not
        System.out.println(
                Pattern.matches(regex_expr,input)
        );

        // Case Insensitive Search
        System.out.println(regex_expr.toUpperCase());
        System.out.println(
                Pattern.compile(regex_expr.toUpperCase(),Pattern.CASE_INSENSITIVE)
                        .matcher(input) // Applies regular expression to input
                        .matches() // Returns boolean result
        );

        // Splitting on the basis of found regex
        regex_expr = "B";
        System.out.println(regex_expr);
        System.out.println(
                Pattern.compile(regex_expr)
                        .split(input) // Returns String Array
                        .length // Gets length of array

        );

    }
}
