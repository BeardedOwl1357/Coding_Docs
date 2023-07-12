package exceptionhandling;

public class ExceptionHandlingVariations {
    public static void main(String[] args) {
        // Multiple Catches
        try{
//            int n = 0; // Raises ArrayIndexOutOfBoundsException
            int n = 1; // Raises ArithmeticException
            int[] arr = new int[n];
            arr[0] = 0;
            System.out.println(5 / arr[0]);
        }
        catch(ArrayIndexOutOfBoundsException arrayE){
            arrayE.printStackTrace();
        }
        catch(ArithmeticException arithE){
            arithE.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
