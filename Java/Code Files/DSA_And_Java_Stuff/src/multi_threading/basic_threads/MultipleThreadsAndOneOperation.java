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
