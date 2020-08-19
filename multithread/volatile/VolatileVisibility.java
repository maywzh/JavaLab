public class VolatileVisibility {
    public static volatile int i = 0;

    public static void increase() {
        i++;
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            increase();
        });
        Thread t2 = new Thread(() -> {
            increase();
        });
        Thread t3 = new Thread(() -> {
            increase();
        });
        Thread t4 = new Thread(() -> {
            increase();
        });
        while (true) {
            System.out.println(i);
        }
    }
}