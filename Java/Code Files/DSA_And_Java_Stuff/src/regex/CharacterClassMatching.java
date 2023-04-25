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
    }
}
