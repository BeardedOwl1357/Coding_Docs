package arrays;

public class BasicOperations {
    public static void main(String[] args) {
        // Creating array with custom values
        int[] arr = {12,43,15,653,3,546,345};
        // Accessing and Printing each element
        /* Accessing via index */
        printArrayIndex(arr);
        /* Accessing without index */
        printArrayForEach(arr);
        // Creating an array dynamically
        int n = 15;
        int[] arr2 = new int[n]; // By default, each cell is assigned value of 0
        printArrayIndex(arr2);
    }

    public static void printArrayIndex(int[] arr){
        int size = arr.length;
        for(int i = 0; i < size; ++i)
            System.out.print(arr[i] + " ");
        System.out.println("\n------------------------------------");
    }

    public static void printArrayForEach(int[] arr){
        for(int num : arr)
            System.out.print(num + " ");
        System.out.println("\n------------------------------------");
    }
}
