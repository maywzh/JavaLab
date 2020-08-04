import java.util.concurrent.TimeUnit;

import java.util.concurrent.*;
public class Counter {
    private final Lock lock = new ReentrantLock();
    private int count;

    public void add(int n) {
        if (lock.tryLock(1, TimeUnit.SECONDS)) {
            lock.lock();
            try {
                count += n;
            } finally {
                lock.unlock();
            }
        }

    }
}