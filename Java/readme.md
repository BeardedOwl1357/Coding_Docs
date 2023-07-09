`TABLE OF CONTENTS`

> Do not read this in one go. This is just for referencing purposes

| Topic                                                                                           |
| ----------------------------------------------------------------------------------------------- |
| [Basics](./basics.md)                                                                           |
| [Data Structures](./Code%20Files/DSA_And_Java_Stuff/src/data_structures/readme.md)              |
| [Algorithms](./Algorithms/Algorithms.md)                                                        |
| [Date Time](./Code%20Files/DSA_And_Java_Stuff/src/datetime/DateTime.md)                         |
| [Regular Expressions](./Code%20Files/DSA_And_Java_Stuff/src/regex/Regex.md)                     |
| [Stream Operations] -- TODO                                                                     |
| [String Formatting](./Code%20Files/DSA_And_Java_Stuff/src/stringformattingoperations/readme.md) |
| [Some Useful Classes] -- TODO                                                                   |

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
  - [Getting The Datatype of an object](#getting-the-datatype-of-an-object)
  - [ASCII And Character to Int](#ascii-and-character-to-int)

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

## Getting The Datatype of an object

```java
public class Main{
    public static void main(String args[]){
        Object a = 5, b = 5.0 ,c = "5" ,d = false;
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
