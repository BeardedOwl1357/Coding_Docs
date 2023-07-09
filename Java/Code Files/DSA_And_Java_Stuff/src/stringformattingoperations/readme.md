# Table of Contents

<!-- TOC -->

- [Table of Contents](#table-of-contents)
- [`String.format()`](#stringformat)
  - [Common Flags](#common-flags)
  - [Common Conversion Targets](#common-conversion-targets)
  - [Common Datetime Conversion Targets](#common-datetime-conversion-targets)
- [String Formatting Operations](#string-formatting-operations)
<!-- TOC -->

# `String.format()`

Tutorial : https://youtu.be/IzYCzegyaH0

Syntax for `String.format()`

```
String.format(format_string,variables)
```

The syntax for using format_string is

```
%[parameter_index$][flags][width][.precision]conversion_target
```

Everything in square-brackets (`[]`) is optional. The optional arguments are defined as follows

- `parameter_index` : In a list of different arguments (parameters), we can manually select the variable which we need. **Note : `parameter_index` starts from 1**
- `flags` : Used to give instructions to the format string. Described in [Commonly used flags](#common-flags). **We can use multiple flags together**
- `width` : The length of the output. To ensure that a string of less characters "reaches" the intended length, it adds spaces to fill in the remaining characters (if a `0` flag is used, it fills the space with '0')
- `precision` : This is applicable for float datatype. Used for defining the number of decimal digits the variable should display
- `conversion_target` : The type of variable which will get converted. Refer to [Common Conversion Target](#common-conversion-targets)

## Common Flags

https://docs.oracle.com/javase/8/docs/api/java/util/Formatter.html#dt

| Flag | Use                                                                                                          | Example    | Datatype   |
| ---- | ------------------------------------------------------------------------------------------------------------ | ---------- | ---------- |
| +    | Shows + or - for numbers                                                                                     | +50, -25   | int        |
| -    | Used for left aligning text                                                                                  |            | int        |
| ,    | Shows numbers in [International Number Format](https://www.cuemath.com/numbers/international-number-system/) | 12,345,678 | int        |
| 0    | Result will be 0 padded                                                                                      | 002        | float, int |
| (    | Shows negative numbers in parenthesis                                                                        | (25)       | float,int  |

> For representing numbers in commas (like currency), it is better to use the `NumberFormatter` class.

## Common Conversion Targets

https://docs.oracle.com/javase/8/docs/api/java/util/Formatter.html#dt

| Data Type    | `conversion_target` |
| ------------ | ------------------- |
| String       | `%s`                |
| Intger / int | `%d`                |
| Float        | `%f`                |

## Common Datetime Conversion Targets

https://docs.oracle.com/javase/8/docs/api/java/util/Formatter.html#dt

## Trimming

By default in Java, we can trim only both sides at a time. Left or Right trimming does not exist (unless you use a library or make a custom function). Some available alternatives are present [here](https://www.baeldung.com/java-trim-alternatives)

### Using `replaceAll()`

We can use a regex expression and `replaceAll()` method of a string for left and right trimming purposes, The regular expressions which are used are as follows

- `^\s+` : This checks for 1 or more whitespace characters from starting of string
- `\s+$` : This checks for 1 or more whitespace characters from end of string

> \_In the below code, we use `\\` because java does not have raw strings. For Java 14 and above, we can use multiline strings """ """

```
String s = "               This is good                    ";
String leftTrimmed = s.replaceAll("^\\s+","");
String rightTrimmed = s.replaceAll("\\s+$","");
String fullTrimmed = s.trim();
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
