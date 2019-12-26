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
    public static void main(String[] args) throws InterruptedException {
//        Using thread class
//         ThreadTest thread1 = new ThreadTest();
//         thread1.start();
//         ThreadTest thread2 = new ThreadTest();
//         thread2.start();
//        using runnable interface
//        Thread t1 = new Thread(new RunTest());
//        t1.start();
//        Thread t2 = new Thread(new RunTest());
//        t2.start();
//        try {
//            new Worker().main();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        Thread pool to complete job using fixed thread pool
//        ExecutorService executor = Executors.newFixedThreadPool(2);
//        //num of tasks to work on
//        for(int i = 0; i < 5; i++) {
//            executor.submit(new Processor(i));
//        }
//        executor.shutdown();
//        System.out.println("All tasks submitted.");
//        executor.awaitTermination(1, TimeUnit.DAYS);
//
//        CounDownLatch for multithreading
//        CountDownLatch latch = new CountDownLatch(3);
//        ExecutorService executor = Executors.newFixedThreadPool(3);
//        for(int i = 0; i < 3; i++) {
//            executor.submit(new LatchProcessor(latch));
//        }
//        latch.await();
//        System.out.println("Completed...");

//        Producer consumer with blokingqueue
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    BlockQueue.producer();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    BlockQueue.consumer();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();
//
//
//        Producer consumer with wait and notify
//        WaitNotify wn = new WaitNotify();
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    wn.produce();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    wn.consume();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();
//
//        Avaned example of wait and notify
        AdvWaitNotify wn = new AdvWaitNotify();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
