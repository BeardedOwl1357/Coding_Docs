**Data Structures**

<!-- TOC -->

- [Arrays](#arrays)
  - [Array Operations](#array-operations)
  - [Sorting Arrays](#sorting-arrays)
  - [Variable Arguments](#variable-arguments)
- [Heap](#heap)
  - [Basic Info](#basic-info)
  - [Creating Max Heap of Integers](#creating-max-heap-of-integers)
  - [Operations](#operations)
  - [Creating a Min Heap of Integers](#creating-a-min-heap-of-integers)
  - [Creating a MaxHeap of int\[\] using custom comparator function](#creating-a-maxheap-of-int-using-custom-comparator-function)
- [Data Structures](#data-structures)
  - [Wrapper Classes](#wrapper-classes)
    - [Autoboxing and Unboxing](#autoboxing-and-unboxing)
  - [Collections](#collections)
  - [Implemented Data Structures](#implemented-data-structures)
  - [Set](#set)
  - [List](#list)
  - [List](#list-1)
  - [Stack](#stack)
  - [Maps](#maps)
  - [Iterating Over Collection Objects](#iterating-over-collection-objects)
  - [Iterating Over Map Object\*](#iterating-over-map-object)
- [Collections Object](#collections-object)
  - [Sorting and Reversing](#sorting-and-reversing)

# Arrays

- 0 based indexing (counting starts from 0). Element at 0th index is called the "first element".
- The syntax to create an array is defined as

```
<datatype>[] <array_name> = new <datatype>[<size>]
```

- If values are already known, arrays can be assigned like this

```java
public class App{
    public static void main(String args[]){
        int[] abc = {5,4,89};
        for(int x : abc)
            System.out.print(x + " ");
        System.out.println();
    }
}
```

## Array Operations

- This is a primitve array
- Better alternatives such as ArrayList are available in [Collections](#data-structures)

```java
import java.util.*;
public class Main{

    public static void main(String args[]) {
        /* Array Operations */
        double[] arr = new double[3];
        // Default values are 0
        printArray(arr);
        // New values cannot be inserted
        // Changing values
        arr[0] = 5.0;
        arr[1] = 48;
        printArray(arr);
    }

    // Printing arrays
    public static void printArray(double[] arr){
        for(double d : arr)
            System.out.print(d + " ");
        System.out.println();
    }

}
```

## Sorting Arrays

- They are done using the `Arrays.sort()` method from `java.util.Arrays`

```java
import java.util.Arrays;
public class Main{

    public static void main(String args[]) {
        double[] arr = {15.0,157.0,8.0,1.0,8.5};
        printArray(arr);
        Arrays.sort(arr);
        printArray(arr);
    }

    // Printing arrays
    public static void printArray(double[] arr){
        for(double d : arr)
            System.out.print(d + " ");
        System.out.println();
    }

}
```

## Variable Arguments

- Allows a function to have various parameters of the same data type
- Uses arrays as "internal implementation"

**The variable argument must be the final / last parameter in the function.**

See the following example

```java
public class App{
    public static void sum(int ...nums){
        int Sum = 0;
        for(int x : nums)
            Sum += x;
        System.out.println("Sum = " + Sum);
    }
    public static void main(String args[]){
        sum();
        sum(1);
        sum(1,2);
        sum(1,2,3,4,5);
        sum(new int[] {1,2,3,4,5,6,7});
    }
}
```

# Heap

## Basic Info

- Library : `java.util.PriorityQueue`

## Creating Max Heap of Integers

```java
PriorityQueue<Integer> maxPQ = new PriorityQueue<>((Integer v1, Integer v2) -> {
    if(v1 < v2) return 1;
    if(v1.equals(v2)) return 0;
    return -1 ; // If v1 > v2
});
// Add an element : add() method
maxPQ.add(5); maxPQ.add(45); maxPQ.add(12); maxPQ.add(164);
System.out.println("Max Heap = " + maxPQ);
```

## Operations

```java
System.out.println("MaxHeap = " + maxPQ);
System.out.println("peek() : " + maxPQ.peek());
System.out.println("remove() : " + maxPQ.remove());
System.out.println("\t Checking whether remove() worked or not : " + maxPQ.peek());
System.out.println("\t MaxHeap = " + maxPQ);
```

## Creating a Min Heap of Integers

```java
PriorityQueue<Integer> minPQ = new PriorityQueue<>();
minPQ.add(5); minPQ.add(45); minPQ.add(12); minPQ.add(164);
System.out.println("Min Heap = " + minPQ);
```

## Creating a MaxHeap of int[] using custom comparator function

```java

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
```

# Data Structures

## Wrapper Classes

- They are object representation of primitive data types
  - Basic primitive types on steroids
- The objects of wrapper classes are called "reference datatypes"
- "String" is a wrapper class
- Wrapper class provides additional methods and functionality over primitives BUT they are slower to access than primitives

| Primitive Datatype | Reference Datatype |
| ------------------ | ------------------ |
| int                | Integer            |
| double             | Double             |
| char               | Character          |
| boolean            | Boolean            |

### Autoboxing and Unboxing

- A primitive datatype can be converted to wrapper automatically. This is called autoboxing
- Similarly, a reference datatype can be converted into primitive automatically. This is called unboxing.

## Collections

- A collection is an interface using which other interfaces are built up
- The following data structure interfaces (Collection) build over the collection interface

| Collection        | Quirk                                               |
| ----------------- | --------------------------------------------------- |
| Set               | Unordered unique elements                           |
| List              | Ordered elements, randomly or sequentially accessed |
| Queue and Dequeue | FIFO type data structure                            |
| Map               | Key-Value pair based access                         |

## Implemented Data Structures

- List of data structures which have been implemented for collection
- [This is how the collections "tree" look like](https://static.javatpoint.com/images/java-collection-hierarchy.png)
  - "Implements" mean that the "interface" was used to create the class
  - "Extends" mean that the class inherited from other class

| Collection        | Data Structure                                        |
| ----------------- | ----------------------------------------------------- |
| Set               | HashedSet, TreeSet, LinkedHashSet                     |
| List              | ArrayList, Vector                                     |
| Queue and Dequeue | Queue, LinkedList, Dequeue, PriorityQueue, ArrayDeque |
| Map               | HashMap, TreeMap, EnumMap                             |
| Stack             | Stack                                                 |

## Set

**Common Methods**

| Method             | Function                                     |
| ------------------ | -------------------------------------------- |
| add(`<data>`)      | Inserts `<data>` into set                    |
| remove(`<data>`)   | Removes `<data>` from set                    |
| contains(`<data>`) | Checks whether `<data>` exists in set or not |
| size()             | Gets number of elements inside the set       |

```java
// To import all data structures at once
// import java.util.*

import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
public class Main{
    public static void main(String args[]) {
        // HashSet
        Set hs = new HashSet(); // Does not maintain the order
        hs.add("x"); hs.add("y"); hs.add(5); // No problem with different datatypes
        System.out.println(hs);

        // LinkedHashSet
        hs = new LinkedHashSet(); // Maintains order of insertion
        hs.add("x"); hs.add("y"); hs.add(5); // No problem with different datatypes
        System.out.println(hs);

        // TreeSet
        hs = new TreeSet(); // Ascending Order.
        hs.add(15); hs.add(2); hs.add(5); // Must contain same datatype
        System.out.println(hs);
    }
}
```

## List

**Common Methods**

| Method                  | Function                                                                |
| ----------------------- | ----------------------------------------------------------------------- |
| add(`<data>`)           | Inserts `<data>` into list                                              |
| remove(`<data>`)        | Removes `<data>` from list                                              |
| remove(`<index>`)       | Removes data at `<index>` from list                                     |
| get()                   | Checks whether `<data>` exists in set or not                            |
| set(`<index>`,`<data>`) | Changes value of data at `<index>` to `<data>`                          |
| indexOf(`<data>`)       | Returns index of first occurrence of `<data>`. If not found, returns -1 |
| lastIndexOf(`<data>`)   | Returns index of last occurrence of `<data>`. If not found, returns -1  |

```java
// To import all data structures at once
// import java.util.*

import java.util.List;
import java.util.ArrayList;
import java.util.Vector;
import java.util.LinkedList;
public class Main{
    public static void main(String args[]) {
        /* ArrayList is better than Vector */
        List l = new ArrayList();
        // Multiple datatypes can be used
        l.add(1); l.add(2); l.add("x");
        System.out.println(l);

        // Random Access
        for(int i = 0; i < l.size(); ++i){
            System.out.print(l.get(i) + " ");
        }
        System.out.println();

        // Setting data
        System.out.println(l);
        l.set(1,48);
        System.out.println(l);

        // Removing element
        l.remove(l.size() - 1);
        System.out.println(l);
        l.add("x");
        System.out.println(l);
        l.remove("x"); // Removes first occurence of "x"
        System.out.println(l);

        // Getting index of First and Last Occurence of a duplicate element
        l.add(1);
        System.out.println("First Occurrence " + l.indexOf(1));
        System.out.println("Last Occurrence " + l.lastIndexOf(1));
        // If not found, returns -1
        System.out.println("First Occurrence " + l.indexOf(6));
    }
}
```

## List

**Common Methods**

| Method        | Function                                                        |
| ------------- | --------------------------------------------------------------- |
| add(`<data>`) | Inserts `<data>` into queue                                     |
| remove()      | Removes the "head" / "top" of queue. Returns the removed object |
| peek()        | Gets the "head" / "top" of the queue                            |

- By default, Priority Queue is a minqueue
  - To use as a max queue, insert `-1 * element`.
  - To practically use the element of max queue, use absoulte value

```java
// To import all data structures at once
// import java.util.*

import java.util.Queue;
import java.util.PriorityQueue;
import java.util.LinkedList;
public class Main{
    public static void main(String args[]) {
        Queue q = new LinkedList();
        // Insertion. Multiple datatypes allowed
        q.add(1); q.add(2); q.add("x");
        System.out.println(q);

        // Removal : Only head (first element) gets removed
        System.out.println(q);
        q.remove();
        System.out.println(q);

        // Getting head / top.
        System.out.println("Head is " + q.peek());

        /* Priority Queue : Min Queue by default */
        Queue pq = new PriorityQueue();
        // Multiple datatypes are not allowed
        pq.add(3); pq.add(2); pq.add(5);
        System.out.println(pq);

        // Removal : Only head (first element) gets removed
        System.out.println(pq);
        pq.remove();
        System.out.println(pq);

        // Getting head / top.
        System.out.println("Head is " + pq.peek());

        /* Using priority queue as maxQueue */
        pq.clear();
        pq.add(-2); pq.add(-5); pq.add(-3);
        System.out.println(pq); // -5 is at head. For max queue, use absolute value

    }
}
```

## Stack

- It is created by extending the `Vector` class

```java
// To import all data structures at once
// import java.util.*

import java.util.Stack;
public class Main{
    public static void main(String args[]) {

        /* Stack */
        Stack s = new Stack();
        s.add(5); s.add(4); s.add("x");
        System.out.println(s);

        // Removal : LIFO
        s.pop();
        System.out.println(s);

        // Getting top
        System.out.println("Top is " + s.peek());
    }
}
```

## Maps

- Originally not a part of the collections framework
- HashMap : Does not care about order of elements
- TreeMap : Orders elements in ascending order
- LinkedHashMap : Retains order of insertion of elements

**Common Methods**

| Method                         | Function                                                            |
| ------------------------------ | ------------------------------------------------------------------- |
| put(`<key>`,`<value>`)         | Associates `<key>` with `<value>`                                   |
| put(`<key>`,`<value>`)         | Also used to update the value of an existing key                    |
| putIfAbsent(`<key>`,`<value>`) | Inserts `<key> : <value>` if `<key>` does not exist                 |
| get(`<key>`)                   | Returns value assoicated with `<key>`. If not present, returns null |
| remove(`<key>`)                | Removes the `<key>` and value associated with it                    |
| containsKey(`<key>`)           | Checks whether a key exists or not                                  |
| containsValue(`<value>`)       | Checks whether a value exists or not                                |
| entrySet()                     | Converts a set into map. Iterators can then be used                 |
| keySet()                       | Returns a set of keys of map                                        |
| values()                       | Returns a set of values of map                                      |

```java
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;

public class Main{
    public static void main(String args[]){
        /*
            HashMap : Does not care about order of elements
            TreeMap : Orders elements in ascending order
            LinkedHashMap : Retains order of insertion of elements
         */
        Map mp = new HashMap();
        mp.put(5,500); mp.put(2,200); mp.put(3,300);
        System.out.println(mp);

        // If key does not exist, null is returned
        System.out.println(mp.get(7));

        // Inserts key,value if key does not exist
        mp.putIfAbsent(5,400);
        System.out.println(mp);
        mp.putIfAbsent(4,400);
        System.out.println(mp);

        // Updating value of key
        mp.put(5,999);
        System.out.println(mp);

        // Removing an element. If element does not exist, it does not raise any error
        System.out.println("Before removing .. " + mp);
        mp.remove(8);
        mp.remove(2);
        System.out.println("After Removing .. " + mp);

        // Checking whether a key exists or not
        System.out.println(mp.containsKey(5));
        System.out.println(mp.containsKey(7));
        // Checking whether a value exists or not
        System.out.println(mp.containsValue(200));
        System.out.println(mp.containsValue(7));

        System.out.println(mp.keySet()); // Returns a set of keys of map
        System.out.println(mp.values()); // Returns a set of values of map


    }
}
```

## Iterating Over Collection Objects

```java
import java.util.*;

public class Main{
    public static void main(String args[]){
        /* Iterators */
        ArrayList x = new ArrayList();
        x.add(5); x.add(7); x.add(8);
        for(var i = x.iterator(); i.hasNext(); )
        // i.next() gets the value of current iterator and increments it
            System.out.print(i.next() + " ");
        System.out.println();

        /* Enhanced For Loop */
        ArrayList<Integer> y = new ArrayList<Integer>(); // The "type" cannot be a primitive
        y.add(51); y.add(156); y.add(89);
        for(int a : y)
            System.out.print(a + " ");
        System.out.println();

        /* Lambda Functions and forEach()

        *  Lambda functions are defined as (p1,p2,p3,..) -> {}
        *  forEach() iterates over each object of the collection

        */
        ArrayList z = new ArrayList();
        z.add(147); z.add(987); z.add(0);
        z.forEach(value -> {
            System.out.print(value + " ");
        });
    }
}
```

## Iterating Over Map Object\*

- Iterators, Enhanced for loops and forEach() does not work on maps
- Map needs to be converted to entrySet()
- **forEach() is better in maps**

```java
import java.util.*;

public class Main{
    public static void main(String args[]){
        /* Iterators */
        Map x = new HashMap();
        x.put(1,100); x.put(5,500); x.put(3,300);
        var i = x.entrySet().iterator();
        while(i.hasNext()){
            var l = i.next();
            System.out.println(l);
        }

        /* forEach */
        x.forEach((key,value) -> {
            System.out.println(String.format("Key %d : Value %d",key,value));
        });

    }
}
```

# Collections Object

- Importing : `import java.util.Collections`
- Methods : **FOR METHODS TO WORK, DATA STRUCTURE MUST BE MUTABLE**

| Method                                    | Function                                   |
| ----------------------------------------- | ------------------------------------------ |
| sort(`List<>`)                            | Sorts a `List<>` object in ascending order |
| reverseOrder(`List<>`)                    | Reverses a `List<>` object.                |
| sort(`List<>`,Collections.reverseOrder()) | Sorts `List<>` in descending order         |

## Sorting and Reversing

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main{
    public static void main(String args[]){
        // The list object must be mutable
        List<Integer> arr = new ArrayList<>();
        arr.add(156); arr.add(16); arr.add(56); arr.add(6); arr.add(65); arr.add(651);

        // Ascending Order
        System.out.println("Before sorting (Ascending) " + arr);
        Collections.sort(arr);
        System.out.println("After sorting (Ascending) " + arr);

        arr.clear();
        System.out.println();

        // Descending Order
        arr.add(156); arr.add(16); arr.add(56); arr.add(6); arr.add(65); arr.add(651);
        System.out.println("Before sorting (Descending) " + arr);
        Collections.sort(arr,Collections.reverseOrder());
        System.out.println("After sorting (Descending) " + arr);

        arr.clear();
        System.out.println();

        // Reversing a list
        arr.add(156); arr.add(16); arr.add(56); arr.add(6); arr.add(65); arr.add(651);
        System.out.println("Before Reversing " + arr);
        Collections.reverse(arr);
        System.out.println("After Reversing " + arr);
    }
}
```
