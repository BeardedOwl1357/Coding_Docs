package regex;
import java.util.regex.Pattern ; // Used to create a regular expression
import java.util.regex.Matcher; // Used for applying regular expression on a string

import java.util.List;

public class Basics {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile(".xx."); // Checks for strings where xx is the 2nd and 3rd character and string is of length 4
        List<String> s = List.of("axxb", "abbbb", "axb", "xxxx", "axxxa");
        for(String str : s){
            Matcher match = pattern.matcher(str); // Applies regex to the string "str"
            boolean matches = match.matches(); // Checks whether regex is satisfied or not
            System.out.println("String = " + str + "\t Matches = " + matches);
        }
    }
}
