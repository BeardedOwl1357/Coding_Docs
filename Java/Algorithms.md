# Table of Contents

- [Algorithms](#algorithms)
  - [Subarrays](#subarrays)
    - [Prefix Sum](#prefix-sum)
    - [Partial Sum](#partial-sum)

# Algorithms

- This contains common algorithms and their code
- Written in java

## Subarrays

### Prefix Sum

- [Prefix Sum Video](https://youtu.be/Z759sE5JWPI)
- Complexity
  - Time Complexity = O(Q)
  - Space Complexity = O(n)

```java
// Java Code
public class Main{
    public static void main(String args[]){
        int arr[] = {1,4,5,2,6};
        int n = arr.length;
        /* Subarray Sums
            [1] = 1
            [4] = 4
            [5] = 5
            [2] = 2
            [6] = 6
            [1,4] = 5
            [4,5] = 9
            [5,2] = 7
            [2,6] = 8
            [1,4,5] = 10
            [4,5,2] = 11
            [5,2,6] = 13
            [1,4,5,2] = 12
            [4,5,2,6] = 17
            [1,4,5,2,6] = 18
         */
		// Create Prefix Array
        int[] p = new int[n];
        p[0] = arr[0];
        for(int i = 1; i < n; ++i)
            p[i] += p[i-1] + arr[i];

		/* Finding sum of subarrays
            * For 0 based indexing L and R
            * Sum of subarray is defined as p[R] - P[L-1]
            * If L = 0, then sum = P[R]
         */
        // Taking input of L and R
        int L = 1, R = 3; // Subarray = [4,5,2], sum = 11
        System.out.println(p[R] - p[L-1]);
    }
}
```

### Partial Sum

- [Partial Sum Video](https://youtu.be/4GXV2W0y0wA)
- Complexity
  - Time Complexity = O(Q)
  - Space Complexity = O(1) // since we already have `p` as input

```java
// Java Code
import java.util.List;
import java.util.ArrayList;
public class Main{
    public static void main(String args[]){
        /* Partial Sum : https://youtu.be/4GXV2W0y0wA
            * A query of form L R x is given.
            * We need to add x to all elements between arr[L] and arr[R]
            * An optimized way of doing this is to use prefix sum
            * For a query L R x, we will do the following operation on an array p
                * p[L] += x
                * p[R+1] -= x
            * After all the above operations have been performed, we will take prefix sum of p
            * We will then get the final array
         */
        int n = 6;
        int[] p = new int[n];
        ArrayList<List<Integer>> q = new ArrayList<>();
        q.add(List.of(2,4,1));
        q.add(List.of(1,5,3));
        q.add(List.of(0,2,2));
        System.out.println("Array Before");
        printArray(p);
        for(var itr = q.iterator(); itr.hasNext(); )
        {
            List li = itr.next();
            int L = (int)li.get(0), R = (int)li.get(1), x = (int)li.get(2);
            p[L] += x;
            if(R+1 < n)
                p[R+1] -= x;
        }
        // Now take prefix sum
        for(int i =1 ; i < n; ++i)
            p[i] += p[i-1];
        System.out.println("Array after");
        printArray(p);
    }

    public static void printArray(int arr[]){
        for(int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }

}
```
