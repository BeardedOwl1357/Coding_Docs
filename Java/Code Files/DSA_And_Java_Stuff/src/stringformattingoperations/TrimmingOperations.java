package stringformattingoperations;

public class TrimmingOperations {
    public static void main(String[] args) {
        String s = "               This is good                    ";
        String leftTrimmed = s.replaceAll("^\\s+","");
        String rightTrimmed = s.replaceAll("\\s+$","");
        String fullTrimmed = s.trim();
        System.out.println("x" + s + "x" + "\n");
        System.out.println("x" + leftTrimmed + "x" + "\n");
        System.out.println("x" + rightTrimmed + "x" + "\n");
        System.out.println("x" + fullTrimmed + "x" + "\n");
    }
}
