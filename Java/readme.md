`TABLE OF CONTENTS`

> Do not read this in one go. This is just for referencing purposes

| Specific Topic | Access Link                                         |
| -------------- | --------------------------------------------------- |
| OOPS           | [Access by clicking here](OOPS/readme.md)           |
| Algorithms     | [Access by clicking here](Algorithms/Algorithms.md) |
| Spring         | [Access by clicking here](Spring-Java/readme.md)    |

- [Progress](#progress)
- [Basics](#basics)
  - [Basic Structure of a Program](#basic-structure-of-a-program)
  - [Variables](#variables)
  - [Local Variable Type Inference](#local-variable-type-inference)
  - [Taking input](#taking-input)
  - [Arithmetic Operators](#arithmetic-operators)
  - [Modulo](#modulo)
- [Format Strings](#format-strings)
  - [Conversion Characters](#conversion-characters)
  - [TODO : Width and Precision](#todo--width-and-precision)
  - [Flags](#flags)
- [Conditionals](#conditionals)
  - [Logical Operators](#logical-operators)
  - [If-Else](#if-else)
  - [Switch Statement](#switch-statement)
- [Operator Precedence](#operator-precedence)
- [Looping](#looping)
  - [While Loop](#while-loop)
  - [For Loop](#for-loop)
  - [Continue Statement](#continue-statement)
  - [Break Statement](#break-statement)
  - [For-Each Loop](#for-each-loop)
- [Functions / Methods](#functions--methods)
  - [Basics](#basics-1)
  - [Variable Scope](#variable-scope)
  - [Function Overloading](#function-overloading)
- [Arrays](#arrays)
  - [Array Operations](#array-operations)
  - [Sorting Arrays](#sorting-arrays)
  - [Variable Arguments](#variable-arguments)
- [TODO : String Operations](#todo--string-operations)
  - [Summarised](#summarised)
  - [Interning and String Comparison](#interning-and-string-comparison)
  - [Multiline Strings (Codeblocks)](#multiline-strings-codeblocks)
  - [StringBuilder : String on Steroids](#stringbuilder--string-on-steroids)
  - [Performance Comparison Between String and StringBuilder](#performance-comparison-between-string-and-stringbuilder)
  - [Printing all substrings of a string](#printing-all-substrings-of-a-string)
  - [Toggling case of each character in a String](#toggling-case-of-each-character-in-a-string)
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
- [Exception Handling and File Handling](#exception-handling-and-file-handling)
  - [Exception Handling](#exception-handling)
    - [Basic Try-Catch](#basic-try-catch)
    - [Handling Exceptions](#handling-exceptions)
    - [Finally](#finally)
    - [Creating and Throwing Custom Exceptions](#creating-and-throwing-custom-exceptions)
  - [File Handling](#file-handling)
    - [Reading](#reading)
    - [Writing](#writing)
    - [Appending](#appending)
- [Miscellaneous](#miscellaneous)
  - [Tutorials](#tutorials)
  - [Math Library](#math-library)
  - [Getting The Datatype of an object](#getting-the-datatype-of-an-object)
  - [ASCII And Character to Int](#ascii-and-character-to-int)

# Progress

- [Track progress](progress.md)

# Basics

## Basic Structure of a Program

- A .java file is called a class
- The main program is a class

  - This class has methods inside it
  - The "first" method (also called entry point of the program) is called `main()`

- For a class (program) called "App", the main() method is defined as follows

```java
public class App{
    public static void main(String args[]){

    }
}
```

## Variables

- Statically typed language
  - Define type of variable manually
- Type conversion is not implicit
  - Multiplying `double` and `float` will result in a double and cannot be stored in an integer

> Characters are represented using ' (single quotations). Strings are represented using " (double quotation)

| Keyword | Datatype                            | Size   |
| ------- | ----------------------------------- | ------ |
| byte    | Integer                             | 8 bit  |
| short   | Integer                             | 16 bit |
| int     | Integer                             | 32 bit |
| long    | Integer                             | 64 bit |
| float   | Decimals (32 bit)                   | 32 bit |
| double  | Decimals (64 bit)                   | 64 bit |
| boolean | Stores boolean values (true, false) | 1 bit  |
| char    | Stores a character                  | 16 bit |

## Local Variable Type Inference

- If value of a variable is assigned as soon as it is initialised (created), then its type can be auto determined
- To do so, use the `var` keyword
- **ONLY USED FOR LOCAL VARIABLES**
- Example

```java
public class App{
    public static void main(String args[]){
        var x = 5;
        var y = 3.14;
        var z = false;
        System.out.println(x + "\t" + y + "\t" + z);
    }
}
```

## Taking input

- Steps to take input

  1. Import the Scanner class : `import java.util.Scanner`
  2. Create a Scanner object which takes input : `Scanner scanner = new Scanner(System.in)`
  3. Derive the value of appropriate datatype
  4. Close the scanner when all inputs have been taken

- Example

```java
import java.util.Scanner;

public class App{
    public static void main(String args[]){
        String name; int num; boolean alive;
        // Initialise scanner
        Scanner scanner = new Scanner(System.in);

        // Prompt user and take input

        System.out.println("What is your name?");
        name = scanner.nextLine(); // For taking string input

        System.out.println("What is your favorite number?");
        num = scanner.nextInt(); // For taking int input

        System.out.println("Are you alive? (false/true)");
        alive = scanner.nextBoolean(); // For taking string input

        // Display user data
        System.out.println(name + "\t" + num + "\t" + alive);

        // Close the scanner when all inputs have been taken
        scanner.close();

    }
}
```

## Arithmetic Operators

- 5 universal operators
- Each operator (except "+") works only on numeric datatypes

| Operator | Action                                   |
| -------- | ---------------------------------------- |
| `+`      | Addition. (Also, used to append strings) |
| `-`      | Subtraction                              |
| `*`      | Multiplication                           |
| `/`      | Division                                 |
| `%`      | Modulo                                   |

## Modulo

```java
public class App{

    // This is how the modulo operation works in Java
    public static int mod(int x, int y){
        return x - (x/y) * y;
    }

    public static void main(String args[]){
        System.out.println(5%3 + "\t" + mod(5,3));
        System.out.println(-5%3 + "\t" + mod(-5,3));
    }
}
```

# Format Strings

- [Tutorial](https://www.youtube.com/watch?v=c2B_Av3x65s)
- Command is `System.out.printf()`

> `System.out.printf()` does not append newline ("\n") in the output

- General syntax of format specifier

`% [flags] [precision] [width] [conversion-character]`

## Conversion Characters

- List of conversion characters

| Conversion Character | Datatype       |
| -------------------- | -------------- |
| %d                   | Integer        |
| %c                   | Character      |
| %s                   | String         |
| %f                   | Float / Double |
| %b                   | Boolean        |

## TODO : Width and Precision

## Flags

- Flags available

| Flag | Purpose                                                   |
| ---- | --------------------------------------------------------- |
| +    | Shows positive(+) /negative(-) symbol for a numeric value |
| -    | Left justify text                                         |
| 0    | Used for padding                                          |
| ,    | Used for separating (when numbers > 1000)                 |

- Padding is done with "Width"

# Conditionals

## Logical Operators

| Operator | Symbol |
| -------- | ------ |
| AND      | &&     |
| OR       | \|\|   |
| NOT      | !      |

## If-Else

```java
import java.util.Scanner;

public class App{
    public static void main(String args[]){
        int drinkingAge = 21, drivingAge = 18, currentAge;
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your current age?");
        currentAge = scanner.nextInt();
        if(currentAge >= drivingAge){
            if(currentAge >= drinkingAge)
                System.out.println("Can both drink and drive");
            else
                System.out.println("Can drive but not drink");
        }
        else
            System.out.println("Can neither drive nor drink");
        scanner.close();
    }
}
```

## Switch Statement

```java
import java.util.Scanner;

public class App{
    public static void main(String args[]){
        // Creating a scanner to take input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter grade");
        String grade = scanner.next();
        String response = " ";
        switch(grade){
            case "A" : response = "Good Job"; break;
            case "B" : response = "Can be improved"; break;
            case "C" : response = "Work Hard"; break;
            case "F" : response = "Lmao Failed"; break;
            default : response = "Invalid Grade";
        }
        System.out.println(response);
        scanner.close();
    }
}
```

> Generally advisable to use `if-else-if`.

# Operator Precedence

- The article which contains all precedences is this : [Java Operator Precedence](https://www.javatpoint.com/java-operator-precedence)
- A shorthand summary of operator precedence (Note : Terms in `()` means that they have same priority)
  - Parenthesis have the highest priority
  - Logical Operators : && , || , ! ........ Executed from left to right
  - Arithmetic Operators : (\*, /, %), (+, -) .............. Executed from left to right

# Looping

## While Loop

The syntax is

```java
while(condition)
{
    // Do Stuff
}
```

An example program

```java
import java.util.Scanner;

public class App{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many times do wish to be greeted?");
        int count = scanner.nextInt();
        System.out.println("------------------------------");
        // While Loop
        while(count != 0){
            System.out.println(count + "\t" + "Hello Human");
            count -= 1;
        }
        scanner.close();
    }
}
```

## For Loop

- Syntax is

```java
for(initialization,condition,updation){
    // Do stuff
}
```

Sample Program

```java
import java.util.Scanner;

public class App{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many times do wish to be greeted?");
        int count = scanner.nextInt();
        System.out.println("------------------------------");
        // For Loop
        for(; count > 0; count -= 1){
            System.out.println(count + "\t" + "Hello Human");
        }
        scanner.close();
    }
}
```

## Continue Statement

```java
public class App{
    public static void main(String args[]){
        for(int i = 0; i < 5; ++i){
            if(i == 3)
                continue;
            System.out.println(i);
        }
    }
}
```

## Break Statement

```java
public class App{
    public static void main(String args[]){
        for(int i = 0; i < 5; ++i){
            if(i == 3)
                break;
            System.out.println(i);
        }
    }
}
```

## For-Each Loop

- Refer to this : [For-each Loop in Java](https://www.geeksforgeeks.org/for-each-loop-in-java/)

```java
public class App{
    public static void main(String args[]){
        int nums[] = {10,156,8165,321,16,14,32,14};
        for(int num : nums)
            System.out.print(num + " ");
    }
}
```

# Functions / Methods

## Basics

- Here, functions are called methods because everything is an object in Java (and objects have methods)
- The anatomy of a method is as follows

```
<access_modifier> <non_access_modifier> <return_type> <name>(<parameters>)
{
    // Body
}
```

| Term                | Meaning                                                   |
| ------------------- | --------------------------------------------------------- |
| access_modifier     | Defines who can access the function                       |
| non_access_modifier | (Optional) ??                                             |
| return_type         | What kind of data the method returns after it is executed |
| name                | The name by which the method is referred to               |
| parameters          | The input a function takes                                |

Notes:

- By default, the access_modifier for a method is private
- Every method requires a return type. If the method does not return anything, use the `void` return_type
- The singature of a method is the combination of name and its parameters
  - Signature needs to be unique for each method

> Even if name of the two methods is same, if the parameters are different, then they are considered as different methods

## Variable Scope

- Global Variables : Variables which are defined in a class. Can be accessed by any function in the class
- Local Variables : Variables which are local to the "block" (`{}`) they are defined in. Can only be accessed inside the block they are defined in

> In case the global and local variables have same names, then first preference will be given to the local variable.
> To access the global variable and overriding the default behavior (of selecting the local variable first), we use the `this` keyword

## Function Overloading

**Even if name of the two methods is same, if the parameters are different, then they are considered as different methods**

```java
public class App{
    public static int sum(int a, int b){
        return(a+b);
    }
    public static int sum(int a, int b, int c){
        return(a+b+c);
    }

    public static int day(String day){
        int ans;
        switch(day){
            case "Sun" : ans = 1; break;
            case "Mon" : ans = 2; break;
            case "Tue" : ans = 3; break;
            case "Wed" : ans = 4; break;
            case "Thu" : ans = 5; break;
            case "Fri" : ans = 6; break;
            case "Sat" : ans = 7; break;
            default : ans = 0;
        }
        return ans;
    }

    public static String day(int day){
        String ans;
        switch(day){
            case 1 : ans = "Sun"; break;
            case 2 : ans = "Mon"; break;
            case 3 : ans = "Tue"; break;
            case 4 : ans = "Wed"; break;
            case 5 : ans = "Thu"; break;
            case 6 : ans = "Fri"; break;
            case 7 : ans = "Sat"; break;
            default : ans = "X";
        }
        return ans;
    }

    public static void main(String args[]){
        System.out.println(sum(3,4));
        System.out.println(sum(3,4,5));
        System.out.println(day("Mon"));
        System.out.println(day(2));
    }
}
```

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

# TODO : String Operations

## Summarised

**Strings are immutable** : Their value cannot be changed.

[String and StringBuilder in java Playlist (Hindi) ](https://www.youtube.com/watch?v=4ZOV3PYe0y0&list=PL-Jc9J83PIiFIKbdCKuYwsV8KaX-jHe0V)

| Method                       | Function                                                       |
| ---------------------------- | -------------------------------------------------------------- |
| length()                     | Gets length of string                                          |
| charAt(`<index>`)            | Gets the character at `<index>` of string                      |
| split(`<term>`)              | Splits string into array on `<term>`                           |
| substring(`<start>`,`<end>`) | Returns a substring from `<start>` index to `<end>-1` index    |
| substring(`<start>`)         | Returns a substring from `<start>` index to `length()-1` index |
| equals(`<s2>`)               | Compares the string with `<s2>`                                |
| equalsIgnoreCase(`<s2>`)     | Compares the string with `<s2>`, ignoring case                 |

NOTE:

The methods are demonstrated as follows

```java
/* (Hindi Tutorial)
    * https://www.youtube.com/watch?v=4ZOV3PYe0y0&list=PL-Jc9J83PIiFIKbdCKuYwsV8KaX-jHe0V
*/
public class Main{
    public static void main(String args[]){
        String x = "This Is Sparta";
        /*  Char  : | T | h | i | s |   | i | s |   | S | p | a  | r  | t  | a  |
            Index : | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 11 | 12 | 13 |
         */
        System.out.println("Length = " + x.length()); // Returns length of string

        System.out.println(x.charAt(0)); // Returns character at 0th position

        System.out.println(x.substring(1,4)); // "his" will be printed

        System.out.println(x.substring(5)); // "Is Sparta" will be printed

        String[] res = x.split(" "); // Splits String based on " ". Result is an array
        for(String s : res)
            System.out.print(s + " ");
        System.out.println();

        /* Interning and String Comparison
            * All the three strings below have the same value
            * However, one is created using the "new" keyword
            * == operator compares Strings on the basis of "address".
            * s1 and s2 point to the same address where the word "hello" is stored
            * However, s3 (due to dynamically allocated using "new" keyword) is pointing to different memory
            * Therefore, s1 == s3 is false, s2 == s3 is false BUT s1 == s2 is true
            * To compare strings, use equals() and equalsIgnoreCase()
         */
        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");
        String temp = String.format("%b %b %b",s1 == s2 , s2 == s3 ,s1 == s3);
        System.out.println(temp);
        temp = String.format("%b %b %b",s1.equals(s2) , s2.equals(s3) ,s1.equals(s3));
        System.out.println(temp);
    }
}
```

## Interning and String Comparison

- All the three strings below have the same value
- However, one is created using the "new" keyword
- == operator compares Strings on the basis of "address".
- s1 and s2 point to the same address where the word "hello" is stored
- However, s3 (due to dynamically allocated using "new" keyword) is pointing to different memory
- Therefore, s1 == s3 is false, s2 == s3 is false BUT s1 == s2 is true
- To compare strings, use equals() and equalsIgnoreCase()

```java
String s1 = "hello";
String s2 = "hello";
String s3 = new String("hello");
String temp = String.format("%b %b %b",s1 == s2 , s2 == s3 ,s1 == s3);
System.out.println(temp);
temp = String.format("%b %b %b",s1.equals(s2) , s2.equals(s3) ,s1.equals(s3));
System.out.println(temp);
```

## Multiline Strings (Codeblocks)

```java
public class App{
    public static void main(String args[]){
        String x = """
                This is good
                Yay
                "abc" : "def"
                """;
        System.out.println(x);
    }
}
```

## StringBuilder : String on Steroids

- High performance as compared to strings
- Allows the ability to treat string as mutable objects
  - Can append
  - Can remove
  - Can modify

| Method                   | Function                                              |
| ------------------------ | ----------------------------------------------------- |
| length()                 | Gets length                                           |
| append(`<char>`)         | Appends `<char>` at end of string                     |
| charAt(`<i>`)            | Gets character at index `<i>`                         |
| setCharAt(`<i>`,`<val>`) | Sets the value of character at index `<i>` to `<val>` |
| delteCharAt(`<i>`)       | Deletes character at index `<i>`                      |
| insert(`<i>`,`<val>`)    | Inserts `<val>` at `<i>` index                        |
| append(`<val>`)          | Inserts `<val>` at end of string                      |
| toString()               | Converts the StringBuilder object to String object    |

> StringBuilder objects cannot be compared using `equals()` method. To compare them, convert them to string using `toString()` and then use `equals()`

```java
import java.util.*;

public class Main{
    public static void main(String args[]){
        /*  Char  : | T | h | i | s |   | i | s |   | S | p | a  | r  | t  | a  |
            Index : | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 11 | 12 | 13 |
         */
        StringBuilder sb = new StringBuilder("This is Sparta");
        System.out.println(sb); // Prints string
        System.out.println(sb.length()); // Prints length of string
        System.out.println(sb.charAt(0)); // Character at 0th index
        sb.setCharAt(1,'R'); // Setting value at 1st index to 'R'
        System.out.println(sb);

        sb.deleteCharAt(1); // Deleting character at 1st index
        System.out.println(sb);

        sb.insert(1,'H'); // Inserts 'H' at 1st index
        System.out.println(sb);

        sb.append('g'); // Inserts 'g' at end of string
        System.out.println(sb);

    }
}
```

## Performance Comparison Between String and StringBuilder

```java
import java.util.*;

public class Main{
    public static void main(String args[]){
        int n = 100000; // 10^5
        String s = "";
        long start = System.currentTimeMillis();
        for(int i = 0; i < n; ++i)
            s += 'x';
        long end = System.currentTimeMillis();
        System.out.println("String. Time taken = " + (end-start) + " ms");
        // StringBuilder
        StringBuilder sb = new StringBuilder("");
        start = System.currentTimeMillis();
        for(int i = 0; i < n; ++i)
            sb.append('x');
        end = System.currentTimeMillis();
        System.out.println("StringBuilder. Time taken = " + (end-start) + " ms");

        /* Output
        *   String. Time taken = 872 ms
        *   StringBuilder. Time taken = 2-3 ms
        * */
    }
}
```

- This difference is because of immutability of strings

  - Each time when a new character is "added" to the string, a new string is produced
  - This string is generated as follows
    - Copy all characters of the string
    - Add new character
    - Assign this to the variable
  - Thus, "adding" to a string is O(n^2) operation

- However, with StringBuilders, the character is appended at the end of the string
  - No copy operation
  - Thus, an O(1) operation

## Printing all substrings of a string

```java
public class Main{
    public static void main(String args[]){
        // Printing all substrings of a string
        String y = "abcd";
        for(int i = 0; i < y.length(); ++i)
        {
            for(int j = i+1; j <= y.length(); ++j)
                System.out.print(y.substring(i,j) + " ");
            System.out.println();
        }
    }
}
```

## Toggling case of each character in a String

```java
import java.util.*;
public class Main{
    // Whatever Exception a method can throw, needs to be declared in the function signature

    public static void main(String args[]) {
        String s = new String("aaaBBccCDDaeeFf");
        System.out.println(test(s));
    }

    public static String test(String s){
        int n = s.length();
        StringBuilder ans = new StringBuilder(s);
        for(int i = 0; i < n; ++i){
            char c = s.charAt(i);
            if(c <= 'Z')
                ans.setCharAt(i,(char)((c - 'A') + 'a'));
            else
                ans.setCharAt(i,(char)((c - 'a') + 'A'));
        }
        return ans.toString();
    }

}
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
| value()                        | Returns a set of values of map                                      |

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

# Exception Handling and File Handling

## Exception Handling

### Basic Try-Catch

- Whatever statement we think might cause an exception (error) must be executed within a "try" block
- If any exception (error) is thrown, then it can be "catched" (A code which executes when an error is encountered)
- See the following piece of code

```java
import java.util.Scanner;

public class Main{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two integers");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        /* The division operation can cause error if b = 0 */
        try{
        int c = a/b;
        System.out.printf("%d / %d = %d ",a,b,c);
        }catch(Exception e){
            System.out.println("Error... \n" + e.getMessage());
            e.printStackTrace();
        }
    }
}
```

### Handling Exceptions

**Common Methods**

| Method            | Function           |
| ----------------- | ------------------ |
| getMessage()      | Get error messsage |
| printStackTrace() | Prints stack trace |

**Types of Exceptions**

| Type                | Description                                                             |
| ------------------- | ----------------------------------------------------------------------- |
| Checked Exception   | Expected exceptions. Methods declare that they might throw an exception |
| Unchecked Exception | Runtime exceptions. No information known                                |

### Finally

- The code inside the "finally" block executes irrespective of whether an error was caught or not
- Execute the below code with following inputs
  - 5 4
  - 5 0

```java
import java.util.Scanner;

public class Main{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two integers");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        /* The division operation can cause error if b = 0 */
        try{
        int c = a/b;
        System.out.printf("%d / %d = %d \n",a,b,c);
        }catch(Exception e){
            System.out.println("Error... \n" + e.getMessage());
            e.printStackTrace();
        }finally {
            System.out.println("PROGRAM FINISHED");
        }
    }
}
```

### Creating and Throwing Custom Exceptions

- We will extend the `Exception` class to create a `CustomException` class which will throw any error message we provide it
- It is defined as follows

```java
// CustomException.java
package custom;

public class CustomException extends Exception{
    public CustomException(){
        this("This is an error");
    }
    public CustomException(String message){
        super(message);
    }

}

```

```java
// Main.java
import custom.CustomException;
public class Main{
    // Whatever Exception a method can throw, needs to be declared in the function signature
    public static void main(String args[]) throws CustomException{
        int a = 5, b = 0;
        try{
            int c = a / b;
            System.out.println(c);
        }catch(Exception e){
            throw new CustomException("Division by 0");
        }
    }
}
```

## File Handling

- The libraries which are required for file operations are as follows

| Library              | Purpose                                       |
| -------------------- | --------------------------------------------- |
| `java.io.File`       | Used for file creation, reading and deletion. |
| `java.io.FileWriter` | Used for writing and appending purposes       |

**With each file operation, it is recommended to use try-catch blocks to handle the generated exceptions**

Demonstration is as follows

### Reading

```java
import java.io.IOException;
import java.util.Scanner;
import java.io.File; // For reading, creation and deletion
import java.io.FileWriter; // For writing

public class Main{
    public static void main(String args[]){
        // Try-Catch is used for exception handling. Good Practice
        /* Writing */
        try{
            File file = new File("abc.txt");
            Scanner scanner = new Scanner(file);
            for(int i = 0; scanner.hasNextLine(); ++i)
                // %02d means "padded to 2 digits"
                System.out.printf("Line %02d \t\t %s\n",i,scanner.nextLine());
            scanner.close();
        }catch(IOException e){
            System.out.println("Error in file operations");
            e.printStackTrace();
        }
    }
}
```

### Writing

```java
import java.io.IOException;
import java.util.Scanner;
import java.io.File; // For reading, creation and deletion
import java.io.FileWriter; // For writing
public class Main {
    public static void main(String args[]) {
        // Try-Catch is used for exception handling. Good Practice

        /* Writing */
        try {
            FileWriter fileWriter = new FileWriter("abc.txt");
            // If a file does not exist, it creates it for writing
            fileWriter.write("This is good \n"); // Does not add "\n" by default
            fileWriter.write("This is bad \n"); // Does not add "\n" by default
            fileWriter.write("This is nice \n"); // Does not add "\n" by default
            fileWriter.write("This is rice \n"); // Does not add "\n" by default
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error in Writing");
            e.printStackTrace();
        }
    }
}
```

### Appending

```java
import java.io.IOException;
import java.util.Scanner;
import java.io.File; // For reading, creation and deletion
import java.io.FileWriter; // For writing
public class Main{
    public static void main(String args[]){
        // Try-Catch is used for exception handling. Good Practice

        /* Appending */
        try{
            // The second parameter in FileWriter is for "append"
            FileWriter fileWriter = new FileWriter("abc.txt",true);
            fileWriter.write("\n ------------------------- \n");
            fileWriter.write("This is appended stuff \n");
            fileWriter.write("This is appended stuff \n");
            fileWriter.write("This is appended stuff \n");
            fileWriter.close();
        }catch(IOException e){
            System.out.println("Error in appending file");
            e.printStackTrace();
        }
    }
}
```

# Miscellaneous

## Tutorials

- [Java printf 🖨️](https://www.youtube.com/watch?v=c2B_Av3x65s)
- [How to Run Java Program in Visual Studio Code | VS Code Java](https://www.youtube.com/watch?v=KiDwLEikUho)
- [Oracle Documentation : Packages](https://docs.oracle.com/javase/tutorial/java/package/index.html)
- [Packages in Java](https://youtu.be/k7TwStbkK70)
- [Java Tutorial: Creating Packages in Java](https://youtu.be/av816KIz8nM)

## Math Library

```java
import java.lang.Math;

public class Main{
    public static void main(String args[]){
        System.out.println(Math.abs(-5)); // Absolute value
        System.out.println(Math.floor(3.5)); // Floor
        System.out.println(Math.ceil(3.5)); // Ceil
        System.out.println(Math.round(3.6)); // Round
        System.out.println(Math.round(3.4)); // Round
        System.out.println("Max Value = " + Math.max(5,9)); // Max
        System.out.println("Min Value = " + Math.min(5,9)); // Min
    }
}
```

## Getting The Datatype of an object

```java
public class Main{
    public static void main(String args[]){
        Object a = 5;
        Object b = 5.0;
        Object c = "5";
        Object d = false;
        Object[] x = {a,b,c,d};
        for(Object obj : x)
            System.out.println(obj.getClass().getSimpleName());
        System.out.println("---------------");
        // Checking by Typecasting as Object
        int l = 65;
        // We are casting the "l" object into an "Object" class. Every datatype is derived from Object class
        String type = ((Object)l).getClass().getSimpleName();
        System.out.println(type);
    }
}
```

## ASCII And Character to Int

```java
public class Main{
    public static void main(String args[]){
        // NOTE : " (double quotes) means string, ' (single quote) means characters
        System.out.println((int)'A'); // Prints 65
        System.out.println((char)65); // Prints "A"
    }
}
```
