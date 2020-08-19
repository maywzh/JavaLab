public class Main {
    static volatile int a = 0;

    public static void add() {
        synchronized 
        System.out.print("before ");
        System.out.println(a);
        a += 1;
        System.out.print("after ");
        System.out.println(a);
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            int i = 0;
            while (i++ < 100) {
                add();
            }

        });
        Thread t2 = new Thread(() -> {
            int i = 0;
            while (i++ < 100) {
                add();
            }
        });
        Thread t3 = new Thread(() -> {
            int i = 0;
            while (i++ < 100) {
                add();
            }
        });
        t1.start(); // 启动新线程
        t3.start();
        t2.start(); // 启动新线程

    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("start new thread!");
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("start new Runnable!");
    }
}
