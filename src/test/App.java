package test;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.*;

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
//        Advaned example of wait and notify
//        AdvWaitNotify wn = new AdvWaitNotify();
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
//        Renetrant locks
//        Runner runner = new Runner();
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    runner.firstThread();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    runner.secondThread();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();
//        runner.finished();
//        reentrant locks with examples
//        AccountRunner runner = new AccountRunner();
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    runner.firstThread();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    runner.secondThread();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();
//        runner.finished();
//
//        Semaphores
//        ExecutorService executor = Executors.newCachedThreadPool();
//        for(int i = 0; i < 200; i++) {
//            executor.submit(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        Connection.getInstance().connect();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//            });
//        }
//        executor.shutdown();
//        executor.awaitTermination(1, TimeUnit.DAYS);
//
//        Callable
//        ExecutorService executor = Executors.newCachedThreadPool();
//        Future<Integer> future = executor.submit(new Callable<Integer>() {
//            public Integer call() throws Exception {
//                Random random = new Random();
//                int duration = random.nextInt(4000);
//                if(duration > 2000) {
//                    throw new IOException("Sleepin too long...");
//                }
//                System.out.println("started...");
//                Sleep.sleep(duration);
//                System.out.println("Finished");
//                return duration;
//            }
//        });
//        executor.shutdown();
//        executor.awaitTermination(1, TimeUnit.DAYS);
//        try {
//            System.out.println("Result is: " + future.get());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        Interruping Threads
    System.out.println("starting");
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<?> future = executor.submit(new Callable<Void>() {
        @Override
        public Void call() throws Exception{
            Random random = new Random();
            for(int i = 0; i < 1E8; i++) {
                if(Thread.currentThread().isInterrupted()) {
                    System.out.println("interrupted");
                    break;
                }
                Math.sin(random.nextDouble());
            }
            return null;
        }
    });
    executor.shutdown();
    Sleep.sleep(500);
    future.cancel(true);
    executor.awaitTermination(1, TimeUnit.DAYS);
    System.out.println("Finished..");
    }
}
