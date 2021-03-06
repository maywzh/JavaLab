import java.util.concurrent.TimeUnit;

public class SimpleDaemons implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.MICROSECONDS.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("sleep() interrupted");
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true);
            daemon.start();
        }
        System.out.println("All Daemons started");
        TimeUnit.MILLISECONDS.sleep(175);
    }
}