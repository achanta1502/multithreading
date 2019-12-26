package test;

import java.util.concurrent.CountDownLatch;

public class LatchProcessor implements Runnable{
    private CountDownLatch latch;
    public LatchProcessor(CountDownLatch latch) {
        this.latch = latch;
    }
    public void run() {
        System.out.println("Started...");
        Sleep.sleep(3000);
        latch.countDown();
    }
}
