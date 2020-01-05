import java.io.*;
import java.util.*;

public class rectanglesurrounding {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        for (;;) {
            int n = sc.nextInt();
            if (n == 0)
                break;
            boolean[][] arr = new boolean[501][501];
            while (n-- > 0) {
                int r1 = sc.nextInt();
                int c1 = sc.nextInt();
                int r2 = sc.nextInt();
                int c2 = sc.nextInt();
                for (int r = r1; r < r2; r++)
                    for (int c = c1; c < c2; c++)
                        arr[r][c] = true;
            }
            int count = 0;
            for (boolean[] r : arr)
                for (boolean c : r)
                    if (c)
                        count++;
            System.out.println(count);
        }
    }
}