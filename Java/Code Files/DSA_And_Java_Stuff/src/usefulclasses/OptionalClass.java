package usefulclasses;

import java.util.Optional;

public class OptionalClass {

    public static void main(String[] args) {
        Object value = 5; // change to null to see behavior
        Optional opt = Optional.ofNullable(value);
        if(opt.isPresent())
            System.out.println(opt.get());
        else
            System.out.println("Value is null");
    }
}
