package exceptionhandling;

public class FinallyClass {
    // Java does not have "default" parameters
    public static void sayName(String name){
        name = name.length() > 0 ? name : "default";
        System.out.println(name);
    }
    public static void main(String[] args) {
        int a = 15, b = 2;
        try{
            int c = a / b;
            sayName("");
            System.out.println(String.format("%d / %d = %d",a,b,c));
        }catch(Exception e){
            e.printStackTrace();
        }
        finally {
            System.out.println("\n Program Executed. \n");
        }
    }
}
