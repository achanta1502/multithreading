package test;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccountRunner {
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();
    private Account acc1 = new Account();
    private Account acc2 = new Account();
    //toavoid deadlocks
    private void acquireLocks(Lock f, Lock s) {
        while(true) {
            boolean gotFirst = false;
            boolean gotSecond = false;
            try {
                gotFirst = f.tryLock();
                gotSecond = s.tryLock();
            } finally {
                if(gotFirst && gotSecond) {
                    return;
                }
                if(gotFirst) {
                    f.unlock();
                }
                if(gotSecond) {
                    s.unlock();
                }
            }
            Sleep.sleep(1);
        }
    }
    public void firstThread() throws InterruptedException {
        Random random = new Random();
        for(int i = 0; i < 10000; i++) {
            //locks should be made careful or else deadlocks occur
            acquireLocks(lock1, lock2);
            try {
                Account.transfer(acc1, acc2, random.nextInt(100));
            }
            finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }
    public void secondThread() throws InterruptedException {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
           acquireLocks(lock1, lock2);
            try {
                Account.transfer(acc2, acc1, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }
    public void finished() {
        System.out.println("Account 1 balance: " + acc1.getBalance());
        System.out.println("Account 2 balance: " + acc2.getBalance());
        System.out.println("Total balance: " + (acc1.getBalance() + acc2.getBalance()));
    }
}
