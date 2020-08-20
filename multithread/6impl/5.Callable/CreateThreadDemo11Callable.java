import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * CreateThreadDemo11Callable
 */
public class CreateThreadDemo11Callable {
    public static void main(String[] args) throws Exception {
        Callable<Integer> call = () -> {
            System.out.println("线程任务开始执行了....");
            Thread.sleep(2000);
            return 1;
        };
        Callable<String> call2 = () -> {
            System.out.println("线程任务开始执行了....");
            Thread.sleep(3000);
            return "Hello";
        };
        FutureTask<Integer> task = new FutureTask<>(call);
        FutureTask<String> task2 = new FutureTask<>(call2);
        new Thread(task).start();
        new Thread(task2).start();
        // ====================
        // 这里是在线程启动之后，线程结果返回之前
        System.out.println("这里可以为所欲为....");
        // ====================

        // 为所欲为完毕之后，拿到线程的执行结果
        Integer result = task.get();
        String result2 = task2.get();
        System.out.println("主线程中拿到异步任务执行的结果为：" + result);
        System.out.println("主线程中拿到异步任务执行的结果为：" + result2);

    }

}