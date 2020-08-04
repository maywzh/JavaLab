import java.util.Arrays;
import java.util.stream;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        String[] array = new String[] { "Apple", "Orange", "Banana", "Lemon" };
        Arrays.sort(array, Main::cmp);
        System.out.println(String.join(", ", array));
        createNaturalStream().map(BigInteger::multiply).limit(100).forEach(System.out::println);
    }

    static int cmp(String s1, String s2) {
        return s1.compareTo(s2);
    }
}