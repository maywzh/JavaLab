import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>();
        // 在不同的线程读写:
        map.put("A", "1");
        map.put("B", "2");
        map.get("A", "1");
    }
}