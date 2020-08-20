import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class CreateThreadDemo10Timer {
    public static void main(String[] args) {

        // 创建定时器
        Timer timer = new Timer();

        // 提交计划任务
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("定时任务执行了...");
            }
        }, new Date(), 1000);
    }
}