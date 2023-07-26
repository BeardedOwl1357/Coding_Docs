package multi_threading.thread_operations;

import multi_threading.race_condition.MyRunnable;

class MyThread1 extends Thread{
    @Override
    public void run(){
        if(Thread.currentThread().isDaemon())
            System.out.println(Thread.currentThread().getName() +  "\tI am a Daemon Thread");
        else
            System.out.println(Thread.currentThread().getName() +  "\tI am a normal thread");
    }
}

public class DaemonThreadsBasics {
    public static void main(String[] args) {
        Thread t1 = new MyThread1();
        t1.start(); // Not a daemon thread
        Thread t2 = new MyThread1();
        t2.setDaemon(true);
        t2.start();
        // To ensure that daemon thread does something, "main" thread needs to do something lol
        System.out.println("LOL");
    }
}
