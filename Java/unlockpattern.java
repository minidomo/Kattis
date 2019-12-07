import java.io.*;
import java.util.*;

public class unlockpattern {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[3][3];
        int[] f = new int[2];
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++) {
                arr[r][c] = sc.nextInt();
                if (arr[r][c] == 1) {
                    f[0] = r;
                    f[1] = c;
                }
            }
        double dist = 0;
        for (int x = 1; x < 9; x++) {
            int[] s = new int[2];
            for (int r = 0; r < 3; r++)
                for (int c = 0; c < 3; c++)
                    if (arr[r][c] == x + 1) {
                        s[0] = r;
                        s[1] = c;
                    }
            dist += Math.sqrt(Math.pow(s[0] - f[0], 2) + Math.pow(s[1] - f[1], 2));
            f = s;
        }
        System.out.println(dist);
    }
}