package test;

class Processor implements Runnable {
    private int id;
    public Processor(int id) {
        this.id = id;
    }
    public void run() {
        System.out.println("Starting: " + id);
        Sleep.sleep(5000);
        System.out.println("Completed: " + id);
    }
}
