package usefulclasses;
import java.util.Optional;

public class OptionalClass {
    public static void main(String[] args) throws Throwable {
        Optional opt = Optional.ofNullable(null);

        // The functionality below can be used via Optional object as follows
//        if(opt.isPresent())
//            System.out.println(opt.get());
//        else
//            System.out.println("Value is null");
        System.out.println(opt.orElse("Value is null"));
        opt.orElseThrow(() -> {return new Exception("Lmao");});
    }
}
