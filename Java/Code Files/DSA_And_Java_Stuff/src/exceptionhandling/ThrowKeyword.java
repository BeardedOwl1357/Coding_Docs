package exceptionhandling;
import java.util.Scanner;

class UnderAgeException extends RuntimeException{
    UnderAgeException(String msg){
        super(msg);
    }
}

public class ThrowKeyword {
    public static void main(String[] args) {
        // Read user input
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter age");
        int age = sc.nextInt();
        if(age < 18)
            throw new UnderAgeException("Less than 18 years of age. Cannot vote");
        else
            System.out.println("You can vote");
    }
}
