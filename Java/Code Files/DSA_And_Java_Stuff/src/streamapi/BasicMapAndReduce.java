package streamapi;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BasicMapAndReduce {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
        List<Integer> arr = Arrays.asList(15,321,489,1,5,87,46,5,18,4,6,897);
        System.out.println(arr);
        // Divide each number without stream operations
        ArrayList<Integer> ans = new ArrayList<>();
        for(int num : arr)
            ans.add(num / 2);
        System.out.println("Even numbers = " + ans);

        // Separate even numbers via Stream operations
        List<Integer> ans2 = arr.stream() // Converts the data structure into a stream
                .map(i -> i / 2) // On each element `i`, performs `i = i / 2`. The lambda function in map() is called "Consumer"
                .collect(Collectors.toList()); // Collects the results and converts it into a List via toList()
        System.out.println("Even numbers via Stream Operations = " + ans2);

        /* ---------------------- Reduce Operation ---------------------- */
        // Uses all values to create a single value
        // It is an aggregating method
        // Finding the sum of all values without streams
        int sum = 0;
        for(int num : arr)
            sum += num;
        System.out.println("\n\nSum of all values = " + sum);

        // Finding sum of all values With stream operations
        sum = arr.stream()
                .reduce(0,(a,b) -> a+b);
        System.out.println("Sum of all values = " + sum);

        /* More Reduce() operations */
        System.out.println(
                arr.stream().reduce((a,b) -> java.lang.Math.max(a,b)).get()
        );
        /* Optional Class
            * When we pass the java.lang.Math.max(a,b) function in the reduce() method, we get an instance of Optional class
            * Optional class is used to "safely" store values which can be null
            *
         */


    }
}