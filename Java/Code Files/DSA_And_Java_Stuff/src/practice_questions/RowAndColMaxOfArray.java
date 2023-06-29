package practice_questions;
import java.lang.Math;
import java.util.Arrays;
public class RowAndColMaxOfArray {
    public static void main(String[] args) {
        int[][] arr = {
                {3,0,8},
                {2,4,5},
                {9,2,6}
        };
        int rows = arr.length;
        int cols = arr[0].length;

        int[] rowMax = new int[rows] ; Arrays.fill(rowMax,0);
        int[] colMax = new int[cols] ; Arrays.fill(colMax,0);

        for(int row = 0 ; row < rows; ++row){
            for(int col = 0; col < cols; ++col){
                rowMax[row] = Math.max(rowMax[row], arr[row][col]);
                colMax[col] = Math.max(colMax[col], arr[row][col]);
            }
        }
        System.out.println("Row Max"); printArray(rowMax);
        System.out.println("Col Max"); printArray(colMax);
    }

    public static void printArray(int[] arr){
        for(int num : arr)
            System.out.printf("%d ",num);
        System.out.println();
    }
}
