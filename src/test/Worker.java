package test;

import java.util.*;

public class Worker {
    private Random random = new Random();
    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();
    public void stageOne() {
        Sleep.sleep(1);
        list1.add(random.nextInt(100));
    }

    public void stageTwo() {
        Sleep.sleep(1);
        list2.add(random.nextInt(100));
    }

    public void process() {
        for(int i = 0; i < 1000; i++) {
            stageOne();
            stageTwo();
        }
    }
    public void main() {
        System.out.println("sarting.....");
        long start = System.currentTimeMillis();
        process();
        long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start));
        System.out.println("List1 size: " + list1.size() + ", List2 size: " + list2.size());
    }
}