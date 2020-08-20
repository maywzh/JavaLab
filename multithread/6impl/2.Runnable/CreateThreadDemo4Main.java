
public class CreateThreadDemo4Main {
    public static void main(String[] args) throws Exception {
        CreateThreadDemo4Task task = new CreateThreadDemo4Task();
        new Thread(task).start();
        // 主线程的任务，为了演示多个线程一起执行
        while (true) {
            printThreadInfo();
            Thread.sleep(1000);
        }
    }

    /**
     * 输出当前线程的信息
     */
    private static void printThreadInfo() {
        System.out.println("当前运行的线程名为： " + Thread.currentThread().getName());
    }
}