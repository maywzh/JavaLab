import java.util.concurrent.ConcurrentHashMap;

public class StaticSingleton {
    private StaticSingleton() {
    }

    /**
     * 获取实例
     */
    public static StaticSingleton getInstance() {
        return StaticSingletonHolder.instance;
    }

    /**
     * 一个私有的静态内部类，用于初始化一个静态final实例
     */
    private static class StaticSingletonHolder {
        private static final StaticSingleton instance = new StaticSingleton();
    }

    /**
     * 方法A
     */
    public void methodA() {
    }

    /**
     * 方法B
     */
    public void methodB() {
    }

    public static void main(String[] args) {
        ConcurrentHashMap chm = new ConcurrentHashMap<String, Integer>();
        chm.put("Hello", 0);
        chm.put("Hello", 1);
        chm.put("World", 2);
        for (var k : chm.keySet()) {
            System.out.println(chm.get(k));
        }

    }
}