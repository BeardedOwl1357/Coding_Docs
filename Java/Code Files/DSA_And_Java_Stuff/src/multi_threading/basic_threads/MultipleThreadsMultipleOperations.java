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
