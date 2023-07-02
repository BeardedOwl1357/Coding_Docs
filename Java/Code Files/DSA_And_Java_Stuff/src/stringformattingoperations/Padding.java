package stringformattingoperations;

public class Padding {
    public static void main(String[] args) {
        // Padding with 0s on left (This means that the number is right justified)
        String NUM_FORMAT_LEFTPADDING = "%05d"; // Padded to length of 5
        
        String NUM_FORMAT_RIGHTPADDING = "%-5d"; // Initially padded from right with space but the `replace()` method will be used to replace empty-space with 0
        
        String OUTPUT_FORMAT = "%-20s \t %-20s\n"; // Left justified, string of 20 width, left justified
        
        System.out.printf(OUTPUT_FORMAT,"Left Padding","Right Padding");
        for(int num = 1; num <= 100000; num *= 9 )
            System.out.printf(
                    OUTPUT_FORMAT,
                    String.format(NUM_FORMAT_LEFTPADDING,num),
                    String.format(NUM_FORMAT_RIGHTPADDING,num).replace(' ','0')
                    );


    }
}
