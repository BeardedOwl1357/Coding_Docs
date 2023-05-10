# Java Inbuilt Logging
# Important classes
Tutorial = https://youtu.be/W0_Man88Z3Q
Package = `java.util.logging`

| Class          | Use                                                                   |
|----------------|-----------------------------------------------------------------------| 
| Logger         | Used to create a logger object. Using this object, we can write logs  |
| Level          | Used to specify the "importance" of a log                             |
| ConsoleHandler | TBD                                                                   |                                                                 |
| LogManager     | TBD                                                                   |

## Level Class
### Logging Levels  
They are arranged in order of importance
  1. SEVERE
  2. WARNING
  3. INFO
  4. CONFIG
  5. FINE
  6. FINER
  7. FINEST
### Filtering Out Logs
- We can filter out some types of logs. This is done by selecting a `cut-off` value.
- In the order specified at [Logging Levels](#logging-levels), if we select any level as the `cut-off` value, then the levels below it are ignored

# Log4J