import java.util.*;

public class IO {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] map = new int[m][n];
        float[][] fmap = new float[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                fmap[i][j] = sc.nextFloat();
            }
        }
        sc.close();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                System.out.print(fmap[i][j] + " ");
            }
            System.out.println();
        }
    }

}
