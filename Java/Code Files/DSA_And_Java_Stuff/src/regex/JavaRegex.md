Table of Contents 
<!-- TOC -->
* [Overview](#overview)
* [Uses](#uses)
  * [Creating basic regex and matching once](#creating-basic-regex-and-matching-once)
  * [Case insensitive Match](#case-insensitive-match)
  * [Replace every matched subsequence of input string via a lambda function](#replace-every-matched-subsequence-of-input-string-via-a-lambda-function)
  * [Splitting on basis of Regex](#splitting-on-basis-of-regex)
  * [Aggregated Information](#aggregated-information)
  * [Regex Groups : Basic Matching](#regex-groups--basic-matching)
  * [Capturing Groups and then replacing text](#capturing-groups-and-then-replacing-text)
* [Documentation Links](#documentation-links)
<!-- TOC -->

# Overview
- Pattern class (`java.util.regex.Pattern`) is used to create a regular expression
- Matcher class (`java.util.regex.Matcher`) is used to search for the regular expression in the given input

# Uses
## Creating basic regex and matching once
```java
String input = "aaaaaaaaaaaaBcasbaaaaaaaaad";
// Pattern.compile(regex_expr).matcher() returns an object of Matcher class
// Using this, will demonstrate Matcher class methods

// Replace every matched subsequence of input sequence with our string
System.out.println(
    Pattern.compile("aaaa") // 4 consecutive a's
            .matcher(input) // Create a Matcher object
            .matches() // Returns a boolean. Indicates whether regex matches any section of string or not
);
```

## Case insensitive Match
This is done by using `Pattern.CASE_INSENSITIVE` value.
```java
// Case Insensitive Search
String input = "aaaaaaaaaaaaBcasbaaaaaaaaad";
String regex_expr = "a+.*"; // Contains one or more than one "a" and then anything is allowed
System.out.println(
        Pattern.compile(regex_expr,Pattern.CASE_INSENSITIVE)
                .matcher(input) // Applies regular expression to input
                .matches() // Returns boolean result
);
```

## Replace every matched subsequence of input string via a lambda function
Documentation for Matcher class : https://docs.oracle.com/javase/9/docs/api/java/util/regex/Matcher.html
```java
String input = "aaaaaaaaaaaaBcasbaaaaaaaaad";
// Replace every matched subsequence of input string via a lambda function
System.out.println(
        Pattern.compile("aaaa")
                .matcher(input)
                .replaceAll(matchResult -> matchResult.group().toUpperCase() + ":") // group() returns the string which was matched.
);
```

## Splitting on basis of Regex
```java
// Splitting on the basis of found regex
String input = "aaaaaaaaaaaaBcasbaaaaaaaaad";
regex_expr = "B";
System.out.println(
        Pattern.compile(regex_expr)
                .split(input) // Returns String Array
                .length // Gets length of array
);
```

## Aggregated Information
Documentation for MatchResult class : https://docs.oracle.com/javase/9/docs/api/java/util/regex/MatchResult.html
```java
String input = "aaaaaaaaaaaaBcasbaaaaaaaaad";
// Getting aggregated information after applying regex to input
// The results() method generates a stream of MatchResult class
// Each MatchResult Class can be accessed via a forEach loop
System.out.println("MatchResult Objects for 'aaaa' regex");
Pattern.compile("aaaa") // 4 consecutive a's
        .matcher(input) // Creating matcher object
        .results() // Returns a Stream of MatchResult
        .forEach(matchRes -> System.out.println("\t" + matchRes)); // Displays each instance of MatchResultClass

// Getting number of matches of given regex
System.out.println(
        "Number of matches for regex 'aaa' = " +
        Pattern.compile("aaa") // 3 consecutive a's
                .matcher(input) // Create matcher
                .results() // Stream<MatchResult>
                .count() // Number of MatchResult instances means that there were that number of matches
);
```

## Regex Groups : Basic Matching
- Regex Groups : https://youtu.be/c9HbsUSWilw
- For example, if we have a regex like `^\+?(\d{2,3})(\d{10})` for mobile number validation
    - It first checks whether the string starts with one or none `+`
    - Then it checks country code (which can be 2-3 digits long). This is the group 1 and is defined in above as `(\d{2,3})`
    - Then it checks for 10 digit mobile number. This is group 2. Defined as `(\d{10})`
- If any section of regex is included within parenthesis `()`, then it is called a group.
- A group is a subsequence
- Group 0 = input string
```java
String input = """
        +911234567890
        +2561234567890
        911234567890
        2561234567890
        """;
String regex = "^\\+?(\\d{2,3})(\\d{10})"
Pattern.compile(regex,Pattern.MULTILINE)
        .matcher(input)
        .results()
        .map(matchResult -> {
            return "Country Code = " + matchResult.group(1) + // group(1) is for country code
                    "\t\t" +
                    "Mobile Number = " + matchResult.group(2); // group(2) is 10 digit mobile number
        })
        .forEach(System.out::println);
```

## Capturing Groups and then replacing text
- Let us assume that the input contains name in `last_name,first_name` order
- What we want is to change it to `first_name last_name`
```java
String input = """
        Lmao , Ded
        World, Hello
        blabla,  dsfsdf
        """;
String regex = "^\\s*(\\w+)\\s*,\\s*(\\w+)";
Pattern.compile(regex,Pattern.CASE_INSENSITIVE + Pattern.MULTILINE)
        .matcher(input)
        .results()
        .map(matchResult -> {
            return matchResult.group(2) + // group(2) means First Name
                    " " +
                    matchResult.group(1); // group(1) means Last Name
        })
        .forEach(System.out::println);
}
```

# Documentation Links
- [Pattern Class JAVA 9](https://docs.oracle.com/javase/9/docs/api/java/util/regex/Pattern.html)
- [MatchResult class JAVA 9](https://docs.oracle.com/javase/9/docs/api/java/util/regex/MatchResult.html)
- [Matcher class JAVA 9](https://docs.oracle.com/javase/9/docs/api/java/util/regex/Matcher.html)
