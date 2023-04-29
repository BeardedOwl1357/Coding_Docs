package regex;
import java.util.regex.Pattern;

public class MatcherClassStuff {
    public static void main(String[] args) {
        String input = "aaaaaaaaaaaaBcasbaaaaaaaaad";
        // Pattern.compile(regex_expr).matcher() returns an object of Matcher class
        // Using this, will demonstrate Matcher class methods

        // Replace every matched subsequence of input sequence with our string
        System.out.println(
                Pattern.compile("aaaa") // 4 consecutive a's
                        .matcher(input) // Create a Matcher object
                        .replaceAll("AAAA-") // Returns a String where each subsequence which satisfied the regex is replaced by our String ("AAAA-" in this case)
        );

        // Replace every matched subsequence of input string via a lambda function
        System.out.println(
                Pattern.compile("aaaa")
                        .matcher(input)
                        .replaceAll(matchResult -> matchResult.group().toUpperCase() + ":") // group() returns the string which was matched.
        );

        // Getting aggregated information after applying regex to input
        // The results() method generates a stream of MatchResult class
        // Each MatchResult Class can be accessed via a forEach loop
        System.out.println("MatchResult Objects for 'aaaa' regex");
        Pattern.compile("aaaa") // 4 consecutive a's
                .matcher(input) // Creating matcher object
                .results() // Returns a Stream of MatchResult
                .forEach(matchRes -> System.out.println("\t" + matchRes)); // Displays each instance of MatchResultClass

        // Getting number of matches of given regex
        System.out.println(
                "Number of matches for regex 'aaa' = " +
                Pattern.compile("aaa") // 3 consecutive a's
                        .matcher(input) // Create matcher
                        .results() // Stream<MatchResult>
                        .count() // Number of MatchResult instances means that there were that number of matches
        );

        /*
            * Regex Groups : https://youtu.be/c9HbsUSWilw
            * For example, if we have a regex like "^\+?(\d{2,3})(\d{10})" for mobile number validation
                * It first checks whether the string starts with one or none "+"
                * Then it checks country code (which can be 2-3 digits long). This is the group 1 and is defined in above as "(\d{2,3})"
                * Then it checks for 10 digit mobile number. This is group 2. Defined as "(\d{10})
            * If any section of regex is included within parenthesis (), then it is called a group.
            * A group is a subsequence
            * Group 0 = input string
         */
        input = """
                +911234567890
                +2561234567890
                911234567890
                2561234567890
                """;
        Pattern.compile("^\\+?(\\d{2,3})(\\d{10})",Pattern.MULTILINE)
                .matcher(input)
                .results()
                .map(matchResult -> {
                    return "Country Code = " + matchResult.group(1) + // group(1) is for country code
                            "\t\t" +
                            "Mobile Number = " + matchResult.group(2); // group(2) is 10 digit mobile number
                })
                .forEach(System.out::println);
        System.out.println("--------------------");

        // Capturing Groups and then replacing text
        /*
            * Let us assume that the input contains name in `last_name,first_name` order
            * What we want is to change it to `first_name last_name`
         */
        input = """
                Lmao , Ded
                World, Hello
                blabla,  dsfsdf
                """;
        String regex = "^\\s*(\\w+)\\s*,\\s*(\\w+)";
        Pattern.compile(regex,Pattern.CASE_INSENSITIVE + Pattern.MULTILINE)
                .matcher(input)
                .results()
                .map(matchResult -> {
                    return matchResult.group(2) + // group(2) means First Name
                            " " +
                            matchResult.group(1); // group(1) means Last Name
                })
                .forEach(System.out::println);
    }


}
