package multi_threading.thread_operations;

class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName());
        Thread.currentThread().setName("Lmao");
        System.out.println(Thread.currentThread().getName());
    }
}
public class NameBasedMethods {
    public static void main(String[] args) {
        Thread t1 = new MyThread();
        t1.start();
        Thread t2 = new Thread(() -> {
            System.out.println("Thread2 Says Hello");
        });
        t2.start();
        System.out.println("Thread2\t" + t2.getName());
        t2.setName("Doraemon");
        System.out.println("Thread2\t" + t2.getName());
    }
}
