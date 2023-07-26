package multi_threading.race_condition;
import java.time.Instant;

public class MyRunnable implements Runnable {
    private int count = 0;
    @Override
    public void run(){
        for(int i = 0; i < 500; ++i){
            System.out.printf(
                    "%s,%s,%d \n",
                    System.nanoTime(),
                    Thread.currentThread().getName(),
                    this.count++
            );
        }
    }
}
