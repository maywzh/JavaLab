public class CreateThreadDemo7Anonymous {
    public static void main(String[] args) {
        // 基于子类和接口的方式
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    printInfo("Interface");
                }
            }
        }) {
            @Override
            public void run() {
                while (true) {
                    printInfo("sub class");
                }
            }
        }.start();
        // 使用lambda的形式
        new Thread(() -> {
            while (true) {
                printInfo("lambda");
            }
        }).start();

    }

    /**
     * 输出当前线程的信息
     */
    private static void printInfo(String text) {
        System.out.println(text);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}