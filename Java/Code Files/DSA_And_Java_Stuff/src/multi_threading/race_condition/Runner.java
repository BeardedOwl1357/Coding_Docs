package multi_threading.race_condition;

public class Runner {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread t1 = new Thread(myRunnable,"Thread 1");
        Thread t2 = new Thread(myRunnable,"Thread 2");
        t1.start();
        t2.start();
    }
}
