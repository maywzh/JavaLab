import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> mutable = new ArrayList<>();
        mutable.add("apple");
        mutable.add("pear");
        // 变为不可变集合:
        List<String> immutable = Collections.unmodifiableList(mutable);
        // mutable.add("orange");
        // System.out.println(immutable);
        // 立刻扔掉mutable的引用:
        mutable = null;
        System.out.println(immutable);

    }
}
