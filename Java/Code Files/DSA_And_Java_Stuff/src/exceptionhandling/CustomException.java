package exceptionhandling;

// Checked Exception
class CustomCheckedException extends Exception{
    public CustomCheckedException(){
        super("This is the default message for CustomCheckedException class");
    }

    // Allows for custom messages in exception
    public CustomCheckedException(String msg){
        super(msg);
    }
}

// Unchecked Exception
class CustomUncheckedException extends RuntimeException{
    public CustomUncheckedException(){
        super("This is the default message for CustomCheckedException class");
    }

    // Allows for custom messages in exception
    public CustomUncheckedException(String msg){
        super(msg);
    }
}

public class CustomException {
    public static void main(String[] args) {
        try{
            check();
        }catch(Exception e){
            System.out.println(e);
        }
        uncheck();
    }

    // Throws checked exception
    public static void check() throws CustomCheckedException{
        throw new CustomCheckedException();
    }

    // Throws unchecked exception
    public static void uncheck(){
        throw new CustomUncheckedException();
    }
}
