Table of Contents

<!-- TOC -->
* [Creating array with custom values](#creating-array-with-custom-values)
* [Accessing via index](#accessing-via-index)
* [Accessing via for-each loop](#accessing-via-for-each-loop)
* [Creating array dynamically](#creating-array-dynamically)
* [`java.util.Arrays` operations](#javautilarrays-operations)
  * [Predfined Functions](#predfined-functions)
  * [Libraries Used](#libraries-used)
  * [Sorting in ascending order](#sorting-in-ascending-order)
  * [Sorting in descending order](#sorting-in-descending-order)
  * [Binary Search](#binary-search)
  * [Linear Search](#linear-search)
  * [Copying an array (instead of accessing by reference)](#copying-an-array-instead-of-accessing-by-reference)
  * [Checking whether two arrays are equal or not](#checking-whether-two-arrays-are-equal-or-not)
  * [Comparing two arrays](#comparing-two-arrays)
  * [Filling an array with a value](#filling-an-array-with-a-value)
  * [Array to String](#array-to-string)
  * [Array to List](#array-to-list)
  * [List to Array](#list-to-array)
  * [Finding the following](#finding-the-following)
  * [Removing duplicates from array](#removing-duplicates-from-array)
  * [Concatenating two arrays](#concatenating-two-arrays)
  * [Finding common elements of two arrays](#finding-common-elements-of-two-arrays)
<!-- TOC -->

# Creating array with custom values
```java
// Creating array with custom values
int[] arr = {12,43,15,653,3,546,345};
```

# Accessing via index
```java
/* Accessing via index */
int size = arr.length;
for(int i = 0; i < size; ++i)
    System.out.print(arr[i] + " ");
System.out.println("\n------------------------------------");
```

# Accessing via for-each loop
```java
for(int num : arr)
    System.out.print(num + " ");
System.out.println("\n------------------------------------");
```

# Creating array dynamically
```java
int n = 15;
int[] arr2 = new int[n]; // By default, each cell is assigned value of 0
```

-----------------------------

# `java.util.Arrays` operations
## Predfined Functions
There are a few predefined functions
```java
public static void printArray(int[] arr){
    for(int i = 0; i < arr.length; ++i)
        System.out.printf("%d ",arr[i]);
    System.out.println();
}
```

## Libraries Used
```java
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
```

## Sorting in ascending order
```java
Arrays.sort(arr);
printArray(arr);
```

## Sorting in descending order
```java
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
```

## Binary Search
```java
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
```

## Linear Search
```java
/* Linear Search */
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
```

## Copying an array (instead of accessing by reference)
```java
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
```

## Checking whether two arrays are equal or not
```java
// Checking whether two arrays are equal or not
//        int[] a = {1,2,3,4};
//        int[] b = a;
//        int[] c = Arrays.copyOf(a,a.length);
//        c[1] = 4;
System.out.println(Arrays.equals(a,c));
System.out.println(Arrays.equals(a,b));
```

## Comparing two arrays
```java
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
```

## Filling an array with a value
```java
// Filling an array with a value
int[] temp = new int[7];
printArray(temp);
Arrays.fill(temp,15);
printArray(temp);
```

## Array to String
```java
// Array to a String
//        int[] arr = {1,2,3,4};
System.out.println(Arrays.toString(arr));
// output = [1,2,3,4]
System.out.println("====================================");
```

## Array to List
```java
/* Arrays and List conversion */
//        int[] arr = {1,2,3,4};
// To List
List<Integer> l = Arrays.stream(arr) // Creates an IntStream
        .boxed() // Converts to Stream<Integer>
        .collect(Collectors.toList()); // Converts to List<Integer>
System.out.println(l);
```

## List to Array
```java
// From List to Array
printArray(
        l.stream() // Converts List<Integer> to Stream<Integer>
                .mapToInt(ele -> ele.intValue()) // Converts to IntStream
                .toArray() // Converts to int[]
);
```

## Finding the following
```java
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
```

## Removing duplicates from array
```java
// Removing Duplicates
int[] res = {1,2,3,4,4,3,2,5,7,5,5,566,6,6,6,7};
printArray(res);
printArray(
        Arrays.stream(res)
                .distinct()
                .toArray()
);
```

## Concatenating two arrays
```java
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
```

## Finding common elements of two arrays
```java
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
```
