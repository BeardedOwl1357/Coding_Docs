package streamapi;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EvenComparison {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
        List<Integer> arr = Arrays.asList(15,321,489,1,5,87,46,5,18,4,6,897);
        System.out.println(arr);
        // Separate even numbers without stream operations
        ArrayList<Integer> evens = new ArrayList<>();
        for(int num : arr)
            if(num%2 == 0) evens.add(num);
        System.out.println("Even numbers = " + evens);

        // Separate even numbers via Stream operations
        List<Integer> evens2 = arr.stream() // Converts the data structure into a stream
                .filter(i -> i%2 == 0) // Filters based on the given lambda function. Keeps an element if the lambda function returns true. The lambda function is called "Predicate"
                .collect(Collectors.toList()); // Collects the results and converts it into a List via toList()
        System.out.println("Even numbers via Stream Operations = " + evens2);
    }
}