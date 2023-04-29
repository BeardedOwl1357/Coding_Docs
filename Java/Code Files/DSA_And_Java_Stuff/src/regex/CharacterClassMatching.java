package regex;

import java.util.regex.Pattern;


public class CharacterClassMatching {
    public static void main(String[] args) {
        // Checking whether the character is either a,b or c
        Pattern p1 = Pattern.compile("[abc]");
        System.out.println(p1.matcher("a").matches());
        System.out.println(p1.matcher("b").matches());
        System.out.println(p1.matcher("d").matches());

        // Checking whether the character is neither a,b or c
        System.out.println("-------------------------------");
        Pattern p2 = Pattern.compile("[^abc]");
        System.out.println(p2.matcher("b").matches());
        System.out.println(p2.matcher("a").matches());
        System.out.println(p2.matcher("d").matches());

        // In range a-z OR A-Z
        System.out.println("-------------------------");
        Pattern p3 = Pattern.compile("[a-zA-Z]");
        System.out.println(p3.matcher("a").matches());
        System.out.println(p3.matcher("A").matches());
        System.out.println(p3.matcher("X").matches());

        // In range a-z and contains either d,e or f
        System.out.println("-----------------------------");
        Pattern p4 = Pattern.compile("[a-z&&[def]]");
        System.out.println(p4.matcher("xfsdf").matches());
        System.out.println(p4.matcher("e").matches());
        System.out.println(p4.matcher("F").matches());

        // In range a-z and does not contain m-p
        System.out.println("------------------");
        Pattern p5 = Pattern.compile("[a-z&&[^m-p]]");
        System.out.println(p5.matcher("f").matches());
        System.out.println(p5.matcher("o").matches());
        System.out.println(p5.matcher("n").matches());

        // Hackerrank Question
        System.out.println("------------------");
        String input = "The hackerrank team is on a mission to flatten the world by restructuring the DNA of every company on the planet. We rank programmers based on their coding skills, helping companies source great programmers and reduce the time to hire. As a result, we are revolutionizing the way companies discover and evaluate talented engineers. The hackerrank platform is the destination for the best engineers to hone their skills and companies to find top engineers.";
        Pattern p6 = Pattern.compile("hackerrank",Pattern.MULTILINE);
        p6.matcher(input)
                .results()
                .forEach(res -> System.out.println(res.group(1)));
    }
}
