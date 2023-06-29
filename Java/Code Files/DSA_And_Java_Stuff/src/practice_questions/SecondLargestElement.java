package practice_questions;

// Question link : https://www.geeksforgeeks.org/find-second-largest-element-array/
// Both largest and second largest value should be unique
public class SecondLargestElement {
    static int[] arr = {12, 35, 1, 10, 34, 1};
//    static int[] arr = {10,10,10,10,5};

    public static void main(String[] args) {
        int max1 = -1, max2 = -1;
        for(int num : arr){
            if(num == max1 || num == max2)
                continue;
            if(num > max1){
                max2 = max1;
                max1 = num;
            }
            else if(num > max2)
                max2 = num;
        }
        if(max1 == -1 || max2 == -1)
            System.out.println("Unique Second largest does not exist");
        else
            System.out.printf("Largest = %d \t Second Largest = %d \n",max1,max2);
    }
}
