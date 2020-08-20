public class CreateThreadDemo6Anonymous {
    public static void main(String[] args) {
        // 基于子类的方式
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    printThreadInfo();
                }
            }
        }.start();

        // 基于接口的实现
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    printThreadInfo();
                }
            }
        }).start();
    }

    private static void printThreadInfo() {
        System.out.println("当前运行的线程名为： " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}