
class Warehouse {
    public static final int max_zise = 100;
    public int curnum;

    Warehouse() {
    }

    Warehouse(int curnum) {
        this.curnum = curnum;
    }

    public synchronized void produce(int neednum) {
        while (neednum + curnum > max_zise) {
            System.out.println(Thread.currentThread().getName());

            System.out.println("要生产的数量" + neednum + "超过剩余库容量" + (max_zise - curnum) + "，暂时无法生产");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        curnum += neednum;
        System.out.println("已经生产了" + neednum + "个产品，现仓储数量为" + curnum);
        notifyAll();
    }

    public synchronized void consume(int neednum) {

        while (curnum < neednum) {

            try {
                System.out.println(Thread.currentThread().getName());

                System.out.println("消费量为" + neednum + "超过要仓储量" + curnum + "，暂时无法消费");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        curnum -= neednum;
        System.out.println("已经消费了" + neednum + "个产品，现仓储数量为" + curnum);
        notifyAll();
    }
}

class Consumer extends Thread {
    private int neednum;
    private Warehouse warehouse;

    Consumer(int needenum, Warehouse warehouse) {
        this.neednum = needenum;
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        warehouse.consume(neednum);
    }

}

class Producer extends Thread {
    private int neednum;
    private Warehouse warehouse;

    Producer(int needenum, Warehouse warehouse) {
        this.neednum = needenum;
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        warehouse.produce(neednum);
    }
}

/**
 * PCMain
 */
public class PCMain {

    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse(30);
        Consumer c1 = new Consumer(50, warehouse);
        Consumer c2 = new Consumer(20, warehouse);
        Consumer c3 = new Consumer(30, warehouse);
        Producer p1 = new Producer(10, warehouse);
        Producer p2 = new Producer(10, warehouse);
        Producer p3 = new Producer(10, warehouse);
        Producer p4 = new Producer(10, warehouse);
        Producer p5 = new Producer(10, warehouse);
        Producer p6 = new Producer(10, warehouse);
        Producer p7 = new Producer(80, warehouse);
        c1.start();
        c2.start();
        c3.start();
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        p6.start();
        p7.start();

    }
}