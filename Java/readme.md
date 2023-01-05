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
- [OOPS (Object Oriented Programing Systems)](#oops-object-oriented-programing-systems)
  - [Packages](#packages)
  - [Creation of Classes](#creation-of-classes)
  - [Constructors](#constructors)
- [Useful Tutorials](#useful-tutorials)

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

# OOPS (Object Oriented Programing Systems)

## Packages

- It is a "folder" where classes can be categorized
- For example, let us assume we have a "folder" / package called "Geometery".
  - In this, various geometrical figures such as Rectangle, Circle, Square etc. can be stored
  - For each geometrical figure, we need to create a separate class
  - However, they all have one thing in common : That they are geometrical figures
  - Therefore, the package "Geometry" becomes a way to group them
- Check this to learn how to work with packages : [Java-Basic-Package-Example by BeardedOwl1357](https://github.com/BeardedOwl1357/Java-Basic-Package-Example)

## Creation of Classes

- The general syntax to define a class

```
<access_specifier> class <class_name> extends <parent_1>,<parent_2> ... {
    // Body
}
```

> Note : The `extended` keyword is used for inheritance. Ignore it for now. See the below example

```java
public class Rectangle{
    public double length, breadth;

    public Rectangle(){
        this.length = 0;
        this.breadth = 0;
    }

    public Rectangle(double length, double breadth){
        this.length = length; // this.length is the class / global variable
        this.breadth = breadth; // this.breadth is the class / global variable
    }

    public double getArea(){
        return length*breadth;
    }

    public double getPerimeter(){
        return 2*(length + breadth);
    }

    public double getLength(){
        return length;
    }

    public double getBreadth(){
        return breadth;
    }
}
```

## Constructors

- Method which executes when an object is created
- By default, each class has an empty constructor
- The name of the constructor must be the same as the name of the class

# Useful Tutorials

- [Java printf 🖨️](https://www.youtube.com/watch?v=c2B_Av3x65s)
- [How to Run Java Program in Visual Studio Code | VS Code Java](https://www.youtube.com/watch?v=KiDwLEikUho)
- [Oracle Documentation : Packages](https://docs.oracle.com/javase/tutorial/java/package/index.html)
- [Packages in Java](https://youtu.be/k7TwStbkK70)
- [Java Tutorial: Creating Packages in Java](https://youtu.be/av816KIz8nM)

```

```
