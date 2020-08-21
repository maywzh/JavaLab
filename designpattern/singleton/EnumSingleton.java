import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class EnumSingleton {
    private EnumSingleton() {
    }

    private enum Singleton {
        INSTANCE;

        private final EnumSingleton instance;

        Singleton() {
            instance = new EnumSingleton();
        }

        private EnumSingleton getInstance() {

            return instance;
        }
    }

    public static EnumSingleton getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    public static void main(String[] args) {
        ThreadPoolExecutor exe = new ThreadPoolExecutor(6, 12, 1L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(6),
                new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 12; i++) {
            exe.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " " + EnumSingleton.getInstance().hashCode());
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        exe.shutdown();
        while (!exe.isTerminated()) {
        }
        vec.addElement("Hello");
        vec.forEach(x -> {
            System.out.println(x);
        });
        System.out.println("Finished all threads");
    }
}