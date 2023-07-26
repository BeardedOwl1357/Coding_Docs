# Basics
- When `main()` method is called, a thread is created. It is called the **Main Thread**. 
  - To get the name of the thread, `System.out.println(Thread.currentThread().getName());`
  - To set the name of the thread, `System.out.println(Thread.currentThread().setName("Mera"));`

# Different Usages of Threads
## 1 Thread and 1 Operation
```java
class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("Task 1");
    }
}
public class OneThreadOneOperation {
    public static void main(String[] args) {
        Thread th = new MyThread();
        th.start();
    }
}
```
## 1 Thread and Multiple Operations
&cross; This is not possible. A thread is supposed to be the smallest unit capable of performing a task. One thread can perform only one operation

## Multiple Threads and 1 Operations

```java
package multi_threading.basic_threads;

class MyThread1 extends Thread{
    @Override
    public void run(){
        System.out.println(
                System.nanoTime() + "\t"
                + Thread.currentThread().getName()
                        + "\t Task 2"
        );
    }
}
public class MultipleThreadsAndOneOperation {
    public static void main(String[] args) {
        Thread t1 = new MyThread1();
        Thread t2 = new MyThread1();
        Thread t3 = new MyThread1();
        t1.start();
        t2.start();
        t3.start();
    }
}
```
## Multiple Threads and Multiple Operations
```java
package multi_threading.basic_threads;

class MyThread2 extends Thread{
    @Override
    public void run(){
        System.out.println(
                System.nanoTime() + "\t"
                + Thread.currentThread().getName()
                + "\t Task 3"
        );
    }
}

class MyThread3 extends Thread{
    @Override
    public void run(){
        System.out.println(
                System.nanoTime() + "\t"
                + Thread.currentThread().getName()
                + "\t Task 4"
        );
    }
}
class MyThread4 extends Thread{
    @Override
    public void run(){
        System.out.println(
                System.nanoTime() + "\t"
                + Thread.currentThread().getName()
                + "\t Task 5"
        );
    }
}
public class MultipleThreadsMultipleOperations {
    public static void main(String[] args) {
        Thread t1 = new MyThread2();
        Thread t2 = new MyThread3();
        Thread t3 = new MyThread4();
        t1.start();
        t2.start();
        t3.start();
    }
}   
```

# Daemon Threads
- Threads which run in background. Its purpose is to provide service to the thread which called the daemon thread
- Are destroyed as soon as the caller thread exits
- A thread can be set as a Daemon thread only before it has started
- Main thread can never be converted to a Daemon thread 
- Daemon thread inherits properties from parent thread
- If a daemon thread creates another thread, that thread will be a daemon thread by default
- We should assign low priority for daemon threads
- **A daemon thread only executes if the parent thread (the thread which called it) is actually doing something. If not, then the daemon thread will not execute**

# Different Thread Methods
## Summary 

| Category                                              | Methods                                                                                                                                             |
|-------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------| 
| Basic Constructor                                     | `Thread()` , `Thread(Runnable target)`, `Thread(String threadName)`, `Thread(Runnable target, String threadName)`                                   |
| Thread Group Constructor                              | `Thread(ThreadGroup tg, Runnable target)`,`Thread(ThreadGroup tg, String threadName)`, `Thread(ThreadGroup tg, Runnable target, String threadName)` |
| Basic Methods                                         | `run()`, `start()`, `Thread.currentThread()`, `Thread.isAlive()`                                                                                    |
| Naming Methods                                        | `getName()`, `setName(String newThreadName)`                                                                                                        |
| Daemon Threads based Methods                          | `isDaemon()`, `setDaemon(boolean b)`                                                                                                                | 
| Priority Based Methods                                | `getPriority()`, `setPriority(int p)`                                                                                                               |
| Preventing Thread Execution                           | `sleep()`, `yield()`, `join()`                                                                                                                      | 
| Interrupting Thread Execution                         | `interrupt()`, `isInterrupted()` `interrupted()`                                                                                                    |
| Inter Thread Communication (**Part of Object class**) | `wait()`, `notify()`, `notifyAll()`                                                                                                                 |

