package multi_threading.basic_threads;

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
