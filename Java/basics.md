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
