import java.util.*;

public class IO2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String[] ss = s.split(",");
        int sum = 0;
        for (int i = 0; i < ss.length; i++) {
            int thenum = Integer.parseInt(ss[i]);
            System.out.println(thenum);
            sum += thenum;
        }
        System.out.println(sum);
        sc.close();

    }
}