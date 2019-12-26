package test;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockQueue {
    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
    public static void producer() throws InterruptedException {
        Random random = new Random();
        while(true) {
            queue.put(random.nextInt(100));
        }
    }
    public static void consumer() throws InterruptedException {
        Random random = new Random();
        while(true) {
            Sleep.sleep(100);
            if(random.nextInt(10) == 0) {
                Integer value = queue.take();

                System.out.println("Taken value: " + value + "; Queue size is: " + queue.size());
            }
        }
    }
}
