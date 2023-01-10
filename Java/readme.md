Do not read this in one go. This is just for referencing purposes

**TABLE OF CONTENTS**

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
- [TODO : OOPS (Object Oriented Programing Systems)](#todo--oops-object-oriented-programing-systems)
  - [Packages](#packages)
  - [Creation of Classes](#creation-of-classes)
  - [Constructors](#constructors)
  - [Inheritance](#inheritance)
    - [Rules](#rules)
    - [Overriding and Overloading Inherited Methods](#overriding-and-overloading-inherited-methods)
    - [TODO : Sealed Classes](#todo--sealed-classes)
  - [Polymorphism](#polymorphism)
    - [Typecasting](#typecasting)
    - [instanceOf](#instanceof)
  - [Abstraction](#abstraction)
  - [TODO : Interfaces](#todo--interfaces)
  - [OOPS RULES](#oops-rules)
    - [Inheritance](#inheritance-1)
    - [Overriding and Overloading Inherited Methods](#overriding-and-overloading-inherited-methods-1)
    - [Polymorphism](#polymorphism-1)
    - [Abstraction](#abstraction-1)
- [Arrays](#arrays)
  - [Variable Arguments](#variable-arguments)
- [TODO : String Operations](#todo--string-operations)
  - [Length of string](#length-of-string)
  - [Splitting in words](#splitting-in-words)
  - [Reverse](#reverse)
  - [Comparison](#comparison)
  - [Multiline Strings (Codeblocks)](#multiline-strings-codeblocks)
- [Data Structures](#data-structures)
  - [Wrapper Classes](#wrapper-classes)
    - [Autoboxing and Unboxing](#autoboxing-and-unboxing)
  - [Collections](#collections)
  - [Implemented Data Structures](#implemented-data-structures)
  - [Set](#set)
  - [List](#list)
  - [List](#list-1)
  - [Stack](#stack)
- [Miscellaneous](#miscellaneous)
  - [Tutorials](#tutorials)
  - [Math Library](#math-library)
  - [Getting The Datatype of an object](#getting-the-datatype-of-an-object)

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

# TODO : OOPS (Object Oriented Programing Systems)

## Packages

- It is a "folder" where classes can be categorized
- For example, let us assume we have a "folder" / package called "Geometery".
  - In this, various geometrical figures such as Rectangle, Circle, Square etc. can be stored
  - For each geometrical figure, we need to create a separate class
  - However, they all have one thing in common : That they are geometrical figures
  - Therefore, the package "Geometry" becomes a way to group them
- Check this to learn how to work with packages : [Java-Basic-Package-Example by BeardedOwl1357](https://github.com/BeardedOwl1357/Java-Basic-Package-Example)

## Creation of Classes

**The class Object is the superclass to every single class.**

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

## Inheritance

### Rules

- A class can inherit from another class using the `extends` keyword
  **Parent and Child Class**
- A superclass's (parent class) constructor is executed before the subclass (derived class) constructor
- Explicit call to parent class's constructor can be made from the constructor of derived class. It is done by using the `super()` keyword
  - However, this call must be the first line of the constructor
  - Otherwise the program will not work
- If superclass does not have a constructor (explicitly defined default constructor), then the subclass needs to manually invoke the constructor of superclass

**Access Specifiers, functions and constructors**

- Public and Protected fields and methods are inherited by children
- Constructors are not inherited by children
- Private members are not inherited
- Final methods are inherited but cannot be overridden

**Demonstration of Basic Inhertiance**

- A demonstration is as follows
  - The package is "human". This package contains two classes, "Person" and "Employee"
  - Employee class inherits from Person

```java
// Person.java
package humans;

public class Person {
    private int age;
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName,int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }
    // Getters and Setters
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

```

```java
// Employee.java
package humans;

public class Employee extends Person{
    private int id;
    public Employee(String firstName, String lastName, int age, int id) {
        super(firstName,lastName,age);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

```

```java
// Main.java
import humans.Employee;
public class Main{
    public static void main(String args[]){
        Employee emp = new Employee("Sanchay","Joshi",15,163577);
        System.out.println("Full Name = " + emp.getFullName());
        System.out.println("Age = " + emp.getAge());
        System.out.println("ID = " + emp.getId());
    }
}
```

### Overriding and Overloading Inherited Methods

- Terms
  - Overriding : Same function signature BUT different body
  - Overloading : Different function signature (name is same, parameters are different) and different body
- As a matter of convention, whenever we are overriding a method, use the `@Override` symbol
  - Parent Class = "A.java"
  - Derived Class = "B.java"

**Overriding**

```java
// A.java
package humans;

public class A{
    public void greet(){
        System.out.println("I am from Class A");
    }
}
```

```java
// B.java
package humans;

public class B extends A{
    @Override
    public void greet(){
        System.out.println("I am from Class B");
    }
}
```

```java
// Main.java
import humans.A;
import humans.B;
public class Main{
    public static void main(String args[]){
        A a = new A();
        B b = new B();
        a.greet();
        b.greet();
    }
}
```

**Overloading**

```java
// A.java
package humans;

public class A{
    public void greet(){
        System.out.println("Parent Original Function");
    }
}
```

```java
// B.java
package humans;

public class B extends A{
    public void greet(String message){
        System.out.println("Derived, Overloaded Function \n" + message);

    }
}
```

```java
// Main.java
import humans.A;
import humans.B;
public class Main{
    public static void main(String args[]){
        A a = new A();
        B b = new B();
        a.greet();
        b.greet(); // Parent Function
        b.greet("Yeh hai message"); // Overloaded function is
    }
}
```

### TODO : Sealed Classes

- A class which only allows a limited amount of classes to "extend" it (inherit from it)
- [Sealed Classes Tutorial](https://www.youtube.com/watch?v=glvYULuaf-k)

## Polymorphism

- Polymorphism means "Ability to take multiple forms"
- In practical terms, a parent class can act as its children
- Rules
  - An object can have a superclass type and subclass instance
  - If a method is overridden by subclass, then the polymorphic object will execute the overridden method at runtime
- See the below example
  - "Animal" is the parent class
  - "Dog" is derived from "Animal" and has a function called greet();
  - "Cat" is derived from "Animal" and has a function called greet();

```java
// Animal.java
package animals;

public class Animal{
    public void greet(){
        System.out.println("I am an animal");
    }
}
```

```java
// Dog.java
package animals;

public class Dog extends Animal{
    public void greet() {
        System.out.println("I am a dog");
    }
}
```

```java
// Cat.java
package animals;

public class Cat extends Animal{
    public void greet(){
        System.out.println("I am a Cat");
    }
}
```

```java
// Main.java
import animals.*;
public class Main{
    public static void main(String args[]){
        Animal a = new Animal(); // Animal acts like Animal
        Animal d = new Dog(); // Animal acts like Dog
        Animal c = new Cat(); // Animal acts like Cat
        a.greet();
        d.greet();
        c.greet();
    }
}
```

### Typecasting

- We can make the parent object acts as its children HOWEVER to access the fields and methods of the child, a typecasting is required
  - A typecast from parent to child is called downcast

```java
// Dog.java
package animals;

public class Dog extends Animal{
    public void greet() {
        System.out.println("I am a dog");
    }

    public void bite(){
        System.out.println("BITING...");
    }
}
```

```java
// Main.java
import animals.*;
public class Main{
    public static void main(String args[]){
        Animal a = new Dog(); // Animal acts like Dog
        // Animal does not have bite however we can make it bite
        ((Dog)a).bite();
    }
}
```

### instanceOf

- Used to determine whether the object is an instance of a "class" or not
- [Using the code from above](#polymorphism)

```java
// Main.java
import animals.*;
public class Main{
    public static void main(String args[]){
        Animal d = new Dog();
        Animal c = new Cat();
        feed(d);
        feed(c);
        feed(new Animal());
    }

    public static void feed(Animal x){
        if(x instanceof Dog)
            System.out.println("Feeding dog food");
        else if(x instanceof Cat)
            System.out.println("Feeding cat food");
        else
            System.out.println("Feeding meat");
    }
}
```

## Abstraction

- Abstraction is a "true blueprint"

  - It is used as a building block
  - Only serves to be inherited by other classes
  - Cannot be used to create any object
  - Useful for defining the "base" outline

- Abstract classes and methods are templates that are meant to be implemented by their subclasses
- Classes and methods are declared abstract by using the abstract reserved word
- If a subclass inherits from an abstract class, it must implement its abstract methods or the class itself must be declared as abstract
- Abstract classes cannot be instantiated
- Classes and methods are defined as abstract by using the word "abstract"
  - If a class has an abstract method, then the class must be declared as abstract

```java
// Animal.java
package animals;

public abstract class Animal{
    public abstract void greet();
    public abstract void eat();
    public void stateSpecies(){
        System.out.println("I am an animal by species");
    }
}
```

```java
// Dog.java
package animals;

public class Dog extends Animal{
    public void greet() {
        System.out.println("I am a dog");
    }

    @Override
    public void eat(){
        System.out.println("Dog eats");
    }

}
```

```java
// Cat.java
package animals;

public class Cat extends Animal{
    public void greet(){
        System.out.println("I am a Cat");
    }

    @Override
    public void eat() {
        System.out.println("Cat eats");
    }
}
```

```java
// Main.java
import animals.*;
public class Main{
    public static void main(String args[]){
        Animal d = new Dog();
        Animal c = new Cat();
        // Dog
        d.greet();
        d.eat();
        d.stateSpecies();
        // Cat
        c.greet();
        c.eat();
        c.stateSpecies();
    }

}
```

## TODO : Interfaces

[ELI5 of interfaces](https://www.reddit.com/r/explainlikeimfive/comments/1v4i2y/comment/ceom6b1/?utm_source=share&utm_medium=web2x&context=3)

## OOPS RULES

### Inheritance

**Parent and Child Class**

- A superclass's (parent class) constructor is executed before the subclass (derived class) constructor
- Explicit call to parent class's constructor can be made from the constructor of derived class. It is done by using the `super()` keyword
  - However, this call must be the first line of the constructor
  - Otherwise the program will not work
- If superclass does not have a constructor (explicitly defined default constructor), then the subclass needs to manually invoke the constructor of superclass

**Access Specifiers, functions and constructors**

- Public and Protected fields and methods are inherited by children
- Constructors are not inherited by children
- Private members are not inherited
- Final methods are inherited but cannot be overridden

### Overriding and Overloading Inherited Methods

- Terms
  - Overriding : Same function signature BUT different body
  - Overloading : Different function signature (name is same, parameters are different) and different body
- As a matter of convention, whenever we are overriding a method, use the `@Override` symbol

### Polymorphism

- An object can have a superclass type and subclass instance
- If a method is overridden by subclass, then the polymorphic object will execute the overridden method at runtime

### Abstraction

- Abstract classes and methods are templates that are meant to be implemented by their subclasses
- Classes and methods are declared abstract by using the abstract reserved word
- If a subclass inherits from an abstract class, it must implement its abstract methods or the class itself must be declared as abstract
- Abstract classes cannot be instantiated
- Classes and methods are defined as abstract by using the word "abstract"
  - If a class has an abstract method, then the class must be declared as abstract

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

## Length of string

```java
public class App{
    public static void main(String args[]){
        String x = new String("lmao");
        System.out.println("Length of string = " + x.length());
    }
}
```

## Splitting in words

```java
public class App{
    public static void main(String args[]){
        String x = new String("This string has many words");
        String words[] = x.split(" ");
        for(String word : words)
            System.out.print(word + " ");
        System.out.println();
    }
}
```

## Reverse

```java
public class App{
    public static void main(String args[]){
        String s = "This is weird";
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        System.out.println(sb);
    }
}
```

## Comparison

```java
public class App{
    public static void main(String args[]){
        String s1 = "Hello world";
        String s2 = "hello world";
        System.out.println(s1.equals(s2)); // Checks case
        System.out.println(s1.equalsIgnoreCase(s2)); // Ignores Case
    }
}
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

# Miscellaneous

## Tutorials

- [Java printf 🖨️](https://www.youtube.com/watch?v=c2B_Av3x65s)
- [How to Run Java Program in Visual Studio Code | VS Code Java](https://www.youtube.com/watch?v=KiDwLEikUho)
- [Oracle Documentation : Packages](https://docs.oracle.com/javase/tutorial/java/package/index.html)
- [Packages in Java](https://youtu.be/k7TwStbkK70)
- [Java Tutorial: Creating Packages in Java](https://youtu.be/av816KIz8nM)

## Math Library

## Getting The Datatype of an object

```java
import java.lang.Math;

public class Main{
    public static void main(String args[]){
        System.out.println(Math.abs(-5)); // Absolute value
        System.out.println(Math.floor(3.5)); // Floor
        System.out.println(Math.ceil(3.5)); // Ceil
        System.out.println(Math.round(3.6)); // Round
        System.out.println(Math.round(3.4)); // Round
    }
}
```

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
