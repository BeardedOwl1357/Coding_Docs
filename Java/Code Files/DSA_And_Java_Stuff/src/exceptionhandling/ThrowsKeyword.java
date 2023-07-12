package exceptionhandling;

import java.io.IOException;

public class ThrowsKeyword {
    public static void main(String[] args) {
        System.out.println(String.format("Dividing %d by %d",10,0));
        try{
            System.out.println(divide(10,0));
        }catch(Exception e){
            // If we catch `Exception`, then we don't necessarily need to catch IOException
        }
    }

    public static int divide(int x, int y) throws IOException {
        return x/y;
    }
}
