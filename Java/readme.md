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

# Useful Tutorials

- [Java printf 🖨️](https://www.youtube.com/watch?v=c2B_Av3x65s)
- [How to Run Java Program in Visual Studio Code | VS Code Java](https://www.youtube.com/watch?v=KiDwLEikUho)
