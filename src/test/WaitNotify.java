package test;

import java.util.Scanner;

public class WaitNotify {
    public void produce() throws InterruptedException {
    synchronized (this) {
        System.out.println("Producer thread running.....");
        wait();
        System.out.println("Resumed...");
    }
    }

    public void consume() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Sleep.sleep(2000);
        synchronized (this) {
            System.out.println("Waiting for the return key...");
            sc.nextLine();
            System.out.println("Return key pressed");
            notify();
            Sleep.sleep(5000);
        }
    }
}
