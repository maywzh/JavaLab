public class Main {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("start new lambda!");
        });
        t.start(); // 启动新线程
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
