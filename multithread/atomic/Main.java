import java.util.concurrent.atomic;

public class Main {

}

class IdGenerator {
    AtomicLong var = new AtomicLong(0);

    public long getNextId() {
        return var.incrementAndGet();
    }

    // public int incrementAndGet(AtomicInteger var) {
    // int prev, next;
    // do {
    // prev = var.get();
    // next = prev + 1;
    // } while (!var.compareAndSet(prev, next));
    // return next;
    // }
}