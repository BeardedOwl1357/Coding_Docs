package arrays;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UtilArrays {
    public static void main(String[] args) {
        int[] arr = {127, 142, 176, 19, 186, 66, 139, 167, 8, 15, 95, 164, 173, 156, 68};
        printArray(arr);
        System.out.println("====================================");
        // Sorting in Ascending Order
        Arrays.sort(arr);
        printArray(arr);
        System.out.println("====================================");

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
        System.out.println("====================================");
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
        System.out.println("====================================");

        /* Linear Search */
        System.out.println("Linear Search");
        // Does not exist
        System.out.println(
            Arrays.stream(arr)
                    .boxed()
                    .anyMatch(ele -> ele == 5)
        );
        // Exists
        System.out.println(
                Arrays.stream(arr)
                        .boxed()
                        .anyMatch(ele -> ele == 156)
        );
        System.out.println("====================================");

        /* Copying an array
            * By default, if we assign a new array object to an existing object, they point to same location
                * i.e., any changes in either array will be reflected to other
                * Example:
                    * arr1 = {1,2,3,4};
                    * arr2 = arr1;
                    * arr2[1] = 54;
                    * print(arr1) // {1,54,3,4}
                    * print(arr2) // {1,54,3,4}
            * To create copy, we use Arrays.copyOf() method
         */
        int[] a = {1,2,3,4};
        int[] b = a;
        System.out.println("Initially Array a = ");
        printArray(a);
        System.out.println("Initially Array b = ");
        printArray(b);
        a[1] = 54;
        System.out.println("After change, Array a = ");
        printArray(a);
        System.out.println("After change, Array b = ");
        printArray(b);

        // Creating copy
        int[] c = Arrays.copyOf(a,a.length);
        c[1] = 4;
        System.out.println("Original array");
        printArray(a);
        System.out.println("Copy array");
        printArray(c);

        System.out.println("====================================");

        // Checking whether two arrays are equal or not
//        int[] a = {1,2,3,4};
//        int[] b = a;
//        int[] c = Arrays.copyOf(a,a.length);
//        c[1] = 4;
        System.out.println(Arrays.equals(a,c));
        System.out.println(Arrays.equals(a,b));

        System.out.println("====================================");
        /* Comparing via compare() method
            * Compares in lexicographical order.
            * If arrays are equal, returns 0
            * If arr1 is "greater" than arr2, returns positive value
            * If arr1 is "lesser" than arr2, returns negative value
         */

//        int[] arr1 = {1,2,3,4,5};
//        int[] arr2 = {1,2,3,4};
        int[] arr1 = {1,2,3,4};
        int[] arr2 = {4,3,2,1};
        System.out.println(Arrays.compare(arr1,arr2));
        System.out.println(Arrays.compare(arr2,arr1));
        System.out.println(Arrays.compare(arr1,arr1));
        System.out.println("====================================");

        // Filling an array with a value
        int[] temp = new int[7];
        printArray(temp);
        Arrays.fill(temp,15);
        printArray(temp);
        System.out.println("====================================");

        // Array to a String
//        int[] arr = {1,2,3,4};
        System.out.println(Arrays.toString(arr));
            // output = [1,2,3,4]
        System.out.println("====================================");

        /* Arrays and List conversion */
//        int[] arr = {1,2,3,4};
        // To List
       List<Integer> l = Arrays.stream(arr) // Creates an IntStream
                .boxed() // Converts to Stream<Integer>
                .collect(Collectors.toList()); // Converts to List<Integer>
        System.out.println(l);

        // From List to Array
        printArray(
                l.stream() // Converts List<Integer> to Stream<Integer>
                        .mapToInt(ele -> ele.intValue()) // Converts to IntStream
                        .toArray() // Converts to int[]
        );
        System.out.println("====================================");

        // Finding max, min, sum and average
//        int[] arr = {1,2,3,4};
        /* Convert the array to stream and then find max */
        System.out.println(Arrays.stream(arr).max());
        /* Convert the array to stream and then find min */
        System.out.println(Arrays.stream(arr).min());
        /* Convert the array to stream and then find sum */
        System.out.println(Arrays.stream(arr).sum());
        /* Convert the array to stream and then find average */
        System.out.println(Arrays.stream(arr).average());
        /* Convert the array to stream and then find summary of statistics */
        System.out.println(Arrays.stream(arr).summaryStatistics().toString());
        System.out.println("====================================");

        // Removing Duplicates
        int[] res = {1,2,3,4,4,3,2,5,7,5,5,566,6,6,6,7};
        printArray(res);
        printArray(
                Arrays.stream(res)
                        .distinct()
                        .toArray()
        );
        System.out.println("====================================");
        /* Concatenating Two arrays
            * We use System.arrayCopy() method.
            * Syntax is System.arrayCopy(src, srcStartingIndex, dest, destStartingIndex,length)
                * src : The array from which we need data
                * srcStartingIndex : The index in src array from where we need to start copying
                * dest : The array where we need the data to "go into"
                * destStartingIndex : The index in dest array where we need the data in
                * length : Number of elements which need to be copied to dest array from src array
         */
        int[] A1 = {1,2,3,4,5};
        int[] A2 = {10,20,3,4,5,60,70};
        int[] A3 = new int[A1.length + A2.length];
        System.arraycopy(A1,0,A3,0,A1.length);
        System.arraycopy(A2,0,A3,A1.length,A2.length);
        printArray(A3);
        System.out.println("====================================");
        // Finding common elements of two arrays
//        int[] A1 = {1,2,3,4,5};
//        int[] A2 = {10,20,3,4,5,60,70};
        Set<Integer> s1 = Arrays.stream(A1)
                .distinct()
                .boxed()
                .collect(Collectors.toSet());
        Set<Integer> s2 = Arrays.stream(A2)
                .boxed()
                .collect(Collectors.toSet());

        int[] common_elements = s1.stream()
                .filter(item -> s2.stream().anyMatch(ele -> ele.equals(item)))
                .mapToInt(Integer::intValue)
                .toArray();
        printArray(common_elements);
        System.out.println("====================================");
    }

    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length; ++i)
            System.out.printf("%d ",arr[i]);
        System.out.println();
    }
}
