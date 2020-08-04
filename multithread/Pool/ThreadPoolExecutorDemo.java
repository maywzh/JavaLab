import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {
    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 10;
    private static final int KEEP_ALIVE_TIME = 10;

    public static void main(String[] args) {
        // create thread pool
        ThreadPoolExecutor exe = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(QUEUE_CAPACITY), new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 15; i++) {
            Runnable worker = new MyRunnable("run" + i);
            exe.execute(worker); // execute 提交无需返回的任务
            //submit 提交 需要返回的任务 返回Future 
        }
    }
}