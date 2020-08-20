import java.util.Date;

public class MyRunnable implements Runnable {
    private String cmd;

    public MyRunnable(String s) {
        this.cmd = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start.Time = " + new Date());
        processCmd();
        System.out.println(Thread.currentThread().getName() + " End.Time = " + new Date());
    }

    private void processCmd() {
        try {
            System.out.println(cmd);
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.cmd;
    }
}