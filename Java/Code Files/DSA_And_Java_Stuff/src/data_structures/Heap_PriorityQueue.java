package data_structures;
import java.util.PriorityQueue;
public class Heap_PriorityQueue {
    public static void main(String[] args) {
        /* Creating Max Heap of Integers */
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((Integer v1, Integer v2) -> {
            if(v1 < v2) return 1;
            if(v1.equals(v2)) return 0;
            return -1 ; // If v1 > v2
        });
        // Add an element : add() method
        maxPQ.add(5); maxPQ.add(45); maxPQ.add(12); maxPQ.add(164);
        System.out.println("Max Heap = " + maxPQ);
        /* Operations */
        System.out.println("MaxHeap = " + maxPQ);
        System.out.println("peek() : " + maxPQ.peek());
        System.out.println("remove() : " + maxPQ.remove());
        System.out.println("\t Checking whether remove() worked or not : " + maxPQ.peek());
        System.out.println("\t MaxHeap = " + maxPQ);

        /* Creating a Min Heap of Integers */
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        minPQ.add(5); minPQ.add(45); minPQ.add(12); minPQ.add(164);
        System.out.println("Min Heap = " + minPQ);

        /* Creating a MaxHeap of int[] using custom comparator function */
        // This creates a priority queue of int[] where comparison is done based on the first element of array
        PriorityQueue<int[]> arrMaxPQ = new PriorityQueue<>((a,b) -> {
            if(a[0] < b[0]) return 1;
            if(a[0] == b[0]) return 0;
            return -1;
        });
        // Adding an element
        arrMaxPQ.add(new int[] {12,15}); arrMaxPQ.add(new int[] {124,145});
        arrMaxPQ.add(new int[] {1,5}); arrMaxPQ.add(new int[] {4,14});
        System.out.println("Custom MaxHeap");
        for(int[] obj : arrMaxPQ)
            System.out.println(String.format("\t%-3d \t %-3d",obj[0],obj[1]));

    }
}
