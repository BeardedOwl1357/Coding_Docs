package practice_questions;

// https://www.geeksforgeeks.org/move-zeroes-end-array/
public class MoveAll0 {
//    static int[] arr = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0};
    static int[] arr = {1, 2, 0, 4, 3, 0, 5, 0};

    public static void main(String[] args) {
        int low = 0;
        int n = arr.length;
        for(int mid = 0; mid < n; ++mid){
            System.out.println(String.format("Low = %d \t Mid = %d",low,mid));
            if(arr[mid] != 0){
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                ++low;
                printArray(arr);
            }
        }
    }
    public static void printArray(int[] arr){
        for(int num : arr)
            System.out.printf("%d ",num);
        System.out.println("\n-------------------------------");
    }
}
