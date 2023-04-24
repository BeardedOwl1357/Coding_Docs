package streamapi;
import java.util.List;
import java.util.stream.Collectors;

public class UsingSortedAndComparators {
    public static void main(String[] args) {
        List<Integer> arr = List.of(123,5,36,73,234,754,325,756,234,736,123,245);
        // Basic Ascending Order Sorting
        System.out.println(
            arr.stream()
                    .sorted() // Sorts in ascending order
                    .distinct() // Removes duplicates element
                    .collect(Collectors.toList()) // Converts Stream to List
        );
        // Skipping first 5 elements after sorting the array
        System.out.println(
                arr.stream()
                        .sorted() // Sorts in ascending order
                        .distinct() // Removes duplicated element
                        .skip(5) // Skips first 5 elements
                        .collect(Collectors.toList()) // Converts Stream to List
        );
    }
}
