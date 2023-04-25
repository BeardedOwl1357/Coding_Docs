# Character class
- Source : https://www.youtube.com/live/f0lZbeueVzU?feature=share&t=628
- Used for filtering a single character
- They are as follows
  - `&&` is used for intersection purposes

| Expression      | Meaning                                                   |
|-----------------|-----------------------------------------------------------| 
| `[abc]`         | The single character is either "a", "b" or "c"            |
| `[^abc]`        | The single character is neither "a", "b" or "c"           |
| `[a-zA-Z]`      | Single character is in the range a-z OR A-Z **inclusive** |
| `[a-d[m-p]]`    | Single character is in the range a-d OR m-p               |
| `[a-z&&[def]]`  | In the range of a-z and contains either d,e or f          |
| `[a-z&&[^bc]]`  | All characters in range a-z but not "b" and "c"           | 
| `[a-z&&[^m-p]]` | All characters in range a-z but not through m-p           |

# Quantifiers
- Quantifies are used to "quantify" the occurrence of a character
- They are defined as follows

| Quantifier | Meaning                                                 | 
|------------|---------------------------------------------------------| 
| `x*`       | x occurs 0 or more times                                |
| `x+`       | x occurs 1 or more times                                |
| `x?`       | x occurs 0 or 1 times                                   | 
| `x{n}`     | x occurs `n` times                                      |
| `x{n,}`    | x occurs `n` or more times                              |
| `x{n,m}`   | x occurs at least `n` times but not more than `m` times |

# Special Characters
| Character | Meaning                                                 |
|-----------|---------------------------------------------------------| 
| `^`       | When applied outside `[]`, used to denote "starts from" |
| `$`       | Denotes "ends"                                          |

# Metacharacters
| Metacharacter | Meaning                            |
|---------------|------------------------------------| 
| `.`           | Can be any character               |
| `\d`          | Represents digits                  |
| `\D`          | Represents "Non Digits"            |
| `\s`          | Represents whitespace              |
| `\S`          | Represents "Non whitespace"        |
| `\w`          | Can be a lowercase word character  |
| `\W`          | Can be an uppercase word character |
| `\b`          | Represents word boundary           |
| `\B`          | Represents "non word boundary"     |
