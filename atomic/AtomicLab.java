import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicLab
 */
public class AtomicLab {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        for (int b = 0; b < 5; b++) {
            new Thread(() -> {
                for (int a = 0; a < 10; a++) {
                    atomicInteger.incrementAndGet();
                }
            }).start();
        }
        System.out.println(atomicInteger);
    }
}