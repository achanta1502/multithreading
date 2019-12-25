package test;

class ThreadTest extends Thread {

    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println("Test" + i);
            Sleep.sleep(100);
        }
    }
}

class RunTest implements Runnable {
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println("Test" + i);
            Sleep.sleep(100);
        }
    }
}
class App {
    public static void main(String[] args) {
        //Using thread class
        // ThreadTest thread1 = new ThreadTest();
        // thread1.start();
        // ThreadTest thread2 = new ThreadTest();
        // thread2.start();
        //using runnable interface
//        Thread t1 = new Thread(new RunTest());
//        t1.start();
//        Thread t2 = new Thread(new RunTest());
//        t2.start();
        new Worker().main();
    }
}
