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

## How datatypes work

They are objects. Like

- String : "hello".<method>
- int : 5.<methid>
- double : (3.14).<method>
