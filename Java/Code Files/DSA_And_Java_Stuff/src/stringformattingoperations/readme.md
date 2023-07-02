# Table of Contents
<!-- TOC -->
* [Table of Contents](#table-of-contents)
* [`String.format()`](#stringformat)
  * [Common Flags](#common-flags)
  * [Common Conversion Targets](#common-conversion-targets)
  * [Common Datetime Conversion Targets](#common-datetime-conversion-targets)
* [String Formatting Operations](#string-formatting-operations)
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

| Flag | Use                                                                                                          | Example   | Datatype   | 
|------|--------------------------------------------------------------------------------------------------------------|-----------|------------|  
| +    | Shows + or - for numbers                                                                                     | +50, -25  | int        |
| -    | Used for left aligning text                                                                                  |           | int        |
| ,    | Shows numbers in [International Number Format](https://www.cuemath.com/numbers/international-number-system/) | 12,345,678 | int        |
| 0    | Result will be 0 padded                                                                                      | 002       | float, int |
| (    | Shows negative numbers in parenthesis                                                                        | (25)      | float,int  |

> For representing numbers in commas (like currency), it is better to use the `NumberFormatter` class. 

## Common Conversion Targets
https://docs.oracle.com/javase/8/docs/api/java/util/Formatter.html#dt

| Data Type    | `conversion_target` |
|--------------|---------------------|
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

> _In the below code, we use `\\` because java does not have raw strings. For Java 14 and above, we can use multiline strings """ """

```
String s = "               This is good                    ";
String leftTrimmed = s.replaceAll("^\\s+","");
String rightTrimmed = s.replaceAll("\\s+$","");
String fullTrimmed = s.trim();
```