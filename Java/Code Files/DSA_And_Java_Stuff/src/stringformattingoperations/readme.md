# Table of Contents
<!-- TOC -->
* [Table of Contents](#table-of-contents)
* [String Formatting Operations](#string-formatting-operations)
  * [Padding](#padding)
    * [Function Used](#function-used)
    * [Left Padding](#left-padding)
    * [Right Padding](#right-padding)
<!-- TOC -->

# String Formatting Operations
Here are some examples of how to pad using String.format() in Java:

1. Left pad an integer with 0 to a length of 6

```java
int num = 42; // an integer
String padded = String.format("%06d", num); // pad with 0 on the left until 6 digits
System.out.println(padded); // prints 000042
```

2. Right pad an integer with 0 to a length of 4

```java
int num = 42; // an integer
String padded = String.format("%-4d", num).replace(' ', '0'); // pad with spaces on the right until 4 digits and then replace spaces with 0
System.out.println(padded); // prints 4200
```

3. Left pad a float with 0 and 3 decimal places to a length of 10

```java
float num = 3.14f; // a float
String padded = String.format("%010.3f", num); // pad with 0 on the left until 10 characters and round to 3 decimal places
System.out.println(padded); // prints 000003.140
```

4. Pad a string with # to a length of 10

```java
String s = "hello"; // a string
String padded = String.format("%10s", s).replace(' ', '#'); // pad with spaces on the left until 10 characters and then replace spaces with #
System.out.println(padded); // prints #####hello
```