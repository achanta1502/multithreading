package test;

class Sleep {
    public static void sleep(long sec) {
        try {
            Thread.sleep(sec);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}