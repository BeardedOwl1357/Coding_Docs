package generic;

// Creating a generic class
class Box<T>{
    T object;
    Box(T object){
        this.object = object;
    }

    void setValue(T object){
        this.object = object;
    }

    // Using instance of keyword
    void performTask(){
        if(object instanceof Integer)
            System.out.println(String.format("This is an integer. Value = %d",(int) object));
        else if(object instanceof String)
            System.out.println(String.format(
                    "This is a String. Length = %d",
                    ((String) object).length())
            );
        else if(object instanceof Boolean){
            System.out.println("Boolean object");
        }
        else
            System.out.println("Unrecognised type");
    }
}

public class Generics {
    public static void main(String[] args) {
        // Generic Object
        Box b1 = new Box(12);
        System.out.println(b1.object + "\t\t" + b1.object.getClass().getName() );
        b1.setValue("Lmao");
        System.out.println(b1.object + "\t\t" + b1.object.getClass().getName() );

        // Type Safe
        Box<Integer> b2 = new Box<>(15);
        System.out.println(b1.object + "\t\t" + b1.object.getClass().getName() );
//        b2.setValue("S"); // Gives an error
    }
}
