import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
    private AtomicInteger count = new AtomicInteger();

    public void inc() {
        count.incrementAndGet();
    }

    public int get() {
        return count.get();
    }
}