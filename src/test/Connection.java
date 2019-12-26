package test;

import java.util.concurrent.Semaphore;

public class Connection {
    private static Connection instance = new Connection();
    private Semaphore sem = new Semaphore(10);
    private int connection = 0;
    private Connection() {

    }
    public static Connection getInstance() {
        return instance;
    }
    public void connect() throws InterruptedException {
        try{
            sem.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            doConnect();
        } finally {
            sem.release();
        }
    }
    private void doConnect() throws InterruptedException {
    synchronized (this) {
        connection++;
        System.out.println("Current conections: " + connection);
    }
        Sleep.sleep(2000);
        synchronized (this) {
            connection--;
        }
    }
}
