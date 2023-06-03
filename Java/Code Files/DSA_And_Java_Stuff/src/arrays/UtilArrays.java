package arrays;

import java.util.Arrays;
import java.util.Collections;

public class UtilArrays {
    public static void main(String[] args) {
        int[] arr = {127, 142, 176, 19, 186, 66, 139, 167, 8, 15, 95, 164, 173, 156, 68};
        printArray(arr);
        // Sorting in Ascending Order
        Arrays.sort(arr);
        printArray(arr);

        // Sorting in Descending Order
        /*
            * For primitive types (int, double etc), there is no direct inbuilt way.
            * Best way is to manually reverse the array
        */
        Arrays.sort(arr); // Sort to ascending order
        // Reverse array
        int start = 0, end = arr.length - 1;
        while(start < end){
            // Example:
            // arr[start] = 5, arr[end] = 6
            arr[start] = arr[start] + arr[end]; // 5 + 6 = 11
            arr[end] = arr[start] - arr[end]; // 11 - 6 = 5
            arr[start] = arr[start] - arr[end]; // 11 - 5 = 6
            // Increment start, decrement end
            ++start; --end;
        }
        printArray(arr);

        /*
            Binary Search
                * Applicable only on Ascending order sorted array
                * If element exists, its index is returned
                * If element does not exist, a negative value is returned
        */
        Arrays.sort(arr);
        System.out.println("Sorted Array in which Binary Search is applied");
        System.out.println();
        printArray(arr);

        System.out.println(Arrays.binarySearch(arr,127)); // Element exists
        System.out.println(Arrays.binarySearch(arr,77)); // Element does not exist
    }

    public static void printArray(int arr[]){
        for(int i = 0; i < arr.length; ++i)
            System.out.printf("%d ",arr[i]);
        System.out.println("\n-----------------------------");
    }
}
