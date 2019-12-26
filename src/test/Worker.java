package test;

import java.util.*;

public class Worker {
    private Random random = new Random();
    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();
    private Object lock1 = new Object();
    private Object lock2 = new Object();
    public void stageOne() {
        synchronized (lock1) {
            Sleep.sleep(1);
            list1.add(random.nextInt(100));
        }
    }

    public void stageTwo() {
        synchronized (lock2) {
            Sleep.sleep(1);
            list2.add(random.nextInt(100));
        }
    }

    public void process() {
        for(int i = 0; i < 2000; i++) {
            stageOne();
            stageTwo();
        }
    }
    public void main() throws InterruptedException {
        System.out.println("sarting.....");
        long start = System.currentTimeMillis();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                process();
            }
        });
        t.start();
        t.join();
        long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start));
        System.out.println("List1 size: " + list1.size() + ", List2 size: " + list2.size());
    }
}