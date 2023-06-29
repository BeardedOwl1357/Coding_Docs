package practice_questions;

import java.lang.Math;

// Question link : https://www.geeksforgeeks.org/find-the-largest-three-elements-in-an-array/
public class MaxOf3InArray {
    // Making this static because I am accessing this variable via a static function (main)
    static int[] arr = {10, 4, 3, 50, 23, 90};

    public static void main(String[] args) {
        int max1 = -1, max2 = -1, max3 = -1;
        // Assuming that max1 > max2 > max3 after algorithm finishes
        for(int num : arr){
            if(num > max1){
                max3 = max2;
                max2 = max1;
                max1 = num;
            }
            else if(num > max2){
                max3 = max2;
                max2 = num;
            }
            else
                max3 = num;
        }
        System.out.println("Max1 = " + max1);
        System.out.println("Max2 = " + max2);
        System.out.println("Max3 = " + max3);
    }
}
