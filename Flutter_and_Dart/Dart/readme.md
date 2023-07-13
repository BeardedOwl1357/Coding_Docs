Table of Contents

- [Tutorial](#tutorial)
- [Basics](#basics)
  - [Reading and Writing to Console / Stdout](#reading-and-writing-to-console--stdout)
  - [Types of Comments](#types-of-comments)
- [Variables and Datatypes](#variables-and-datatypes)
  - [Datatypes](#datatypes)
  - [The difference between `final` and `const`](#the-difference-between-final-and-const)
  - [Nullable / Optional Variables](#nullable--optional-variables)
  - [How datatypes work](#how-datatypes-work)
  - [Strings](#strings)
- [Control Flow](#control-flow)
  - [Logical Operators](#logical-operators)
  - [IF-ELSE-ELSE IF](#if-else-else-if)
  - [Ternary Operator](#ternary-operator)
- [Loops](#loops)
- [Functions](#functions)
  - [Basic Functions](#basic-functions)
  - [Records (Tuples)](#records-tuples)
    - [Basics](#basics-1)
    - [Named Records](#named-records)
  - [Named Arguments](#named-arguments)
- [OOPS](#oops)
  - [Basics of class](#basics-of-class)
  - [Misc : Immutable Classes](#misc--immutable-classes)
  - [Inheritance](#inheritance)
    - [Extending classes](#extending-classes)
    - [Class Modifiers](#class-modifiers)
    - [Mixins](#mixins)

# Tutorial

- https://www.youtube.com/watch?v=Fqcsow_7go4

# Basics

## Reading and Writing to Console / Stdout

`dart:io` package is used for input / output operations. The code below provides a demonstration

```dart
import 'dart:io';

void main() {
  stdout.writeln("Enter your name");
  String name = stdin.readLineSync().toString();
  // Writing via print
  print("Lmao " + name);
  // Writing via stdout
  stdout.writeln("Lmao " + name);
  // Something like Bash I guess
  print("Lmao $name");
}
  // Printing same text `n` times
  int n = 5;
  print("hello " * n);
```

## Types of Comments

| Comment | Use                   |
| ------- | --------------------- |
| //      | Single line comment   |
| /\* \*/ | Multiline Comment     |
| ///     | Documentation comment |

# Variables and Datatypes

## Datatypes

List of variables is as follows

- Compile Time : `int`,`String`,`bool`,`double`
- Runtime : `dynamic`

| Type    | Description                                                                                                                                                       |
| ------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `var`   | Determines type of variable at runtime. Value can be changed (mutable)                                                                                            |
| `final` | Value cannot change after assignment. Assignment and Declaration can happen independently. Values which are retrieved at runtime can be assigned                  |
| `const` | Value cannot change after assignment. Assignment and Declaration can only happen at once. Only values are allowed which are "constant" (not retrieved on runtime) |

## The difference between `final` and `const`

Source : https://youtu.be/Fqcsow_7go4?t=3251

```dart
void main() {
  // Works
  final currentDateTime = DateTime.now();
  print(currentDateTime);

  // Does not work as the value of DateTime.now() is not determined at compile time
  // const currentDateTime1 = DateTime.now();
}
```

## Nullable / Optional Variables

By default, variables cannot have `null` value. For a variable of any datatype to have null value, we need to add `?` in front of it. For example, see the following snippet of code

- To give a datatype the ability to have a null value, append `?` in front of it. For example, `String?`
- To access an optional variable (a variable which can have null) as if it has the value, use `!`.
- While accessing a field of an object which can be a null, we need to append `?` in front of it. For example, `String? x ; print(x?.length);`
  - If we use the above, we will either get the length of String (if the variable is not null) or get null itself
  - However, we can display / provide a different value instead of null by using `??`. For example, `String? x; print(x?.length ?? 0)`

```dart
void main() {
  // If the below is uncommented, this will give an error as a non-nullable variable cannot have `null` value
  // String x
  String? x;
  print(x); // Has null value

  x = "Lol";
  print(x); // Now has non-null value

  x = null; // We were able to assign null value
  print(x);

  /*
    * Let's try to get the length of a variable which is assigned null
    * For this, we need to use `?` operator while accessing the `length` value
  */
  print(
      "Length of ${x} = ${x!.length}"); // Assumes that `x` is not null and normally tries to access the information
  print(
      "Length of ${x} = ${x?.length}"); // If x is not null, return length else return null
  print(
      "Length of ${x} = ${x?.length ?? 0}"); // If x is not null, return length else return 0
}
```

## How datatypes work

They are objects. Like

- String : "hello".<method>
- int : 5.<method>
- double : (3.14).<method>

## Strings

> BOTH `"` and `'` are used for assigning strings

- Are mutable. Can change values
- FStrings are used via `${}`. This is called "Interpolation" in Dart

```dart
String name = "Ram";
name = "${name} Shyam";
```

> **`$`** has a special meaning in dart. Use **`\$`** to use the literal value of "$"

- Multiline Strings

```dart
  // Multiline String
  String multi_line = """
This is good
Very good
""";
  print(multi_line);
```

# Control Flow

## Logical Operators

- AND : `&&`
- OR : `||`
- NOT : `!`

## IF-ELSE-ELSE IF

```dart

void main() {
  int age = 20;
  // With curly braces
  if (age >= 18 && age <= 25) {
    print("Young Adult");
  } else if (age > 25) {
    print("Experienced Adult");
  } else {
    print("Child");
  }

  // Same logic without curly braces
  if (age >= 18 && age <= 25)
    print("Young Adult");
  else if (age > 25)
    print("Experienced Adult");
  else
    print("Child");
}
```

## Ternary Operator

The syntax for ternary operator is as follows

```
<condition> ? <when condition is True> : <when condition is False>
```

```dart
void main() {
  int age = 20;
  print("Is adult? \t ${age >= 18 ? "Yes" : "No"}");
}
```

# Loops

```dart
void main() {
  // For loop
  for (int i = 0; i < 5; ++i) print("Hello ${i}");

  // While loop
  int i = 5;
  while (i >= 0) {
    print("Mellow ${i}");
    i -= 1;
  }

  // Do-While loop
  do {
    print("Do while ${i}");
    i += 1;
  } while (i != i); // i!=i will always be false

  // Continue keyword. Print first 10 Natural numbers but skip even numbers
  for (int num = 1; num <= 10; ++num) {
    if (num % 2 == 0) continue;
    print("Number = ${num}");
  }

  // Break : Break when we find 7
  for (int num = 1; num <= 10; ++num) {
    if (num == 7) break;
    print("Break Number = ${num}");
  }
}
```

# Functions

It is a good practice to explictly state the datatypes involved in a function (parameters, return types etc). **By default, `dynamic` datatype is used**

## Basic Functions

```dart
int add(int x, int y) {
  return x + y;
}

String displayFullName(String firstName, String lastName) {
  return '${firstName} ${lastName}';
}

void main() {
  print(add(5, 2));
  print(displayFullName("bearded", "owl"));
  (int, String, bool) temp = getMultiple();
  print('All values in temp : ${temp}');
  print('1st value in temp : ${temp.$1}');
  print('2nd value in temp : ${temp.$2}');
  print('3rd value in temp : ${temp.$3}');
}

```

## Records (Tuples)

### Basics

```dart
// Tuples
(int, String, bool) getMultiple() {
  return (10, "Hello", false);
}

void main() {
  print(add(5, 2));
  print(displayFullName("bearded", "owl"));
  (int, String, bool) temp = getMultiple();
  print('All values in temp : ${temp}');
  print('1st value in temp : ${temp.$1}');
  print('2nd value in temp : ${temp.$2}');
  print('3rd value in temp : ${temp.$3}');
}
```

### Named Records

```dart
// Named Records
({int age, String name, bool isAdult}) getNamedMultiple() {
  int age = 10;
  return (age: age, name: "John", isAdult: age >= 18 ? true : false);
}

void main() {
  final stuff = getNamedMultiple();
  print(stuff.runtimeType);

  print(stuff.age);
  print(stuff.name);
  print(stuff.isAdult);
}
```

## Named Arguments

By default, dart uses positional arguments that is, while calling the functions, the function call must have parameters provided to it in the same order as in the definition of the function. Using named arguments, we can avoid this "positional dependency".

```dart
// Named arguments
void printDetails({required String name, required int age, int? salary}) {
  print('Name : ${name}');
  print('Age : ${age}');
  print('Salary : ${salary ?? 0}'); // This statement means "if salary is not null, print salary else print 0"
}

void main() {
  printDetails(name: 'John', age: 25);
  printDetails(name: 'John', age: 25, salary: 1500);
}

```

# OOPS

## Basics of class

https://youtu.be/Fqcsow_7go4?t=9958

There are a few quirks about classes in Dart as compared to other languages. They are defined as follows

- Variables prefixed with `_` are private variables
- We cannot have multiple constructors in a class like we do in other langauges
  - To have multiple constructors, we can have one default constructor and other constructors need to be "named" : https://stackoverflow.com/a/49691200
  - To define a getter for a variable, use `get` keyword. This keyword is prefixed by the datatype of the variable for which are defining the getter. For ease of use, use arrow functions
  - To define a setter for a variable, use `set` keyword. For ease of use, use arrow functions

See the code below and relate to the above points

```dart
class Rectangle {
  // Variables
  // Private variables are prefixed by _
  double _length = 0;
  double _breadth = 0;
  // Constructor
  // Default Constructor
  Rectangle() {
    print('Length = ${_length} \t Breadth = ${_breadth}');
  }

  // Named constructor
  Rectangle.overrided(this._breadth, this._length) {
    print('Length = ${_length} \t Breadth = ${_breadth}');
  }

  /* For functions with a single statement, use arrow functions */

  // Setters
  // By using the `set` keyword, we tell dart that the sole purpose of this method is to set a value.
  set length(double length) => this._length = length;
  set breadth(double breadth) => this._breadth = breadth;

  // Getters
  // By using the `get` keyword, we tell dart that the sole purpose of this method is to get a value and thus, we don't need to use `return` keyword.
  double get length => _length;
  double get breadth => _breadth;

  /* STATIC VARIABLES and METHODS */
  static String NAME = "Raj";
  static int AGE = 25;

  static void greet() => print("Hello Human");
}

void main() {
  // Calling default constructor
  Rectangle rect1 = Rectangle();
  // Calling named constructor
  Rectangle rect2 = Rectangle.overrided(5, 16);

  // Using setters
  rect1.length = 15;
  rect1.breadth = 25;
  rect2.length = 16;
  rect2.breadth = 26;

  // Accessing getters
  print("rect1 length = ${rect1.length} \t rect2 length = ${rect2.length}");
  print("rect1 length = ${rect1.breadth} \t rect2 length = ${rect2.breadth}");

  // Using static variables and methods
  print("Name = ${Rectangle.NAME} \t Age = ${Rectangle.AGE}");
  Rectangle.greet();
}

```

## Misc : Immutable Classes

```dart
class ImmutableRectangle {
  // To make a class immutable, make each variable final
  final double length;
  final double breadth;

  // Make only one constructor
  // Named parameters can only be used on public variables (`_` not allowed)
  ImmutableRectangle({required this.length, required this.breadth});

  // Positional parameters can be used too
  ImmutableRectangle.positional(this.length, this.breadth);
}

void main() {
  ImmutableRectangle rect1 = ImmutableRectangle(length: 10, breadth: 20);
  // rect1.breadth = 10; // Gives error as we cannot change its value once it is assigned
  print("length = ${rect1.length} \t breadth = ${rect1.breadth}");

  // Using positional constructor

  ImmutableRectangle rect2 = ImmutableRectangle.positional(16, 20);
  // rect2.breadth = 16; // Gives error as we cannot change its value once it is assigned
  print("length = ${rect2.length} \t breadth = ${rect2.breadth}");
}

```

## Inheritance

https://youtu.be/Fqcsow_7go4?t=13210

I will be comparing dart to java in this case

- `extends` : Used for inhertiance
- `implements` : Used for implementing classes
- Only one class can be extended (inherited)
- One class can implement many interfaces / classes
- Polymorphism is supported
- Typecasting : `(<object> as <className>)`

### Extending classes

```dart
class Vehicle {
  int _speed = 0;
  void accelerate() => _speed += 10;

  void deaccelerate() => _speed -= 10;

  void applyBrake() {
    while (_speed > 0) this.deaccelerate();
  }

  int get speed => _speed;
  void set speed(int speed) => this._speed = speed;
}

class Car extends Vehicle {
  int _numberOfWheels = 4;
  double _steeringAngleDegrees = 90;

  // The @override annotation is just like Java : program can compile without it but it is still recommended to use it so that the IDE can help detect any errors
  @override
  void accelerate() => _speed += 15;

  @override
  void deaccelerate() => _speed -= 15;

  void steerRight() => _steeringAngleDegrees += 2;
  void steerLeft() => _steeringAngleDegrees += 2;

  int get numberOfWheels => _numberOfWheels;
  double get steeringAngleDegrees => _steeringAngleDegrees;
}

void main() {
  // Polymorphism
  Vehicle c = Car();
  print(c._speed);
  c.speed = 20;
  print(c.speed);

  // Type casting
  print((c as Car)._steeringAngleDegrees);
  (c as Car).steerRight();
  print((c as Car)._steeringAngleDegrees);
}

```

### Class Modifiers

By default, any created class has the following

- Can be extended and implemented by any class
- Can be instantiated
- Methods must be defined and variables can be declared or defined
  They are defined as follows

- `abstract`
  - Methods and variables can be left empty or have implmenetations.
  - Can be extended / implemented
  - For practical usage, it is better to `implement` an abstract class as this allows us to have multiple inheritance (one class implementing many abstract classes)
  - Cannot be instantiated
- `sealed`
  - Cannot be instantiated
  - Prevents classes to implement or extend the "sealed" class
- `final`
  - Prevents classes to implement or extend the "sealed" class
  - Can be instantiated
- `base`
  - Cannot be implemented but extended.
  - When an object of extended class is created, the constructor of base class is also executed
- `interface`
  - Can only be implemented by any class
  - **NOT EQUIVALENT TO `interface` IN JAVA**. To acheive that functionality, use `abstract interface`

### Mixins

It is a "kind of class" which can be "mixed" with any class. We can "mix" more than one mixins with a class. For example, see the following code
