package stringformattingoperations;

public class Padding {
    public static void main(String[] args) {
        System.out.println(String.format("%-20s \t %-20s","Left Padding","Right Padding"));
        /* Left Padding */
        for(int num = 0; num < 100; num += 9){
            /*
                Logic for Left Padding
                    - %06d
                        - 0 = Pad with 0
                        - 6 = Pad to a length of 6
                        - d = Integer

             */
            String leftPadding = String.format("%05d",num);
            String rightPadding = String.format("%-5d",num).replace(' ','0');
            System.out.println(String.format("%-20s \t %-20s",leftPadding,rightPadding));
        }
    }
}
