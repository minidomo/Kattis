import java.io.*;
import java.util.*;

public class thisaintyourgrandpascheckerboard {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] arr = new char[n][n];
        for (int r = 0; r < n; r++) {
            arr[r] = sc.next().toCharArray();
            int rb = 0;
            int rw = 0;
            for (int c = 0; c < n; c++) {
                if (arr[r][c] == 'B')
                    rb++;
                else
                    rw++;
                if (c < n - 2 && arr[r][c] == arr[r][c + 1] && arr[r][c] == arr[r][c + 2]) {
                    System.out.println(0);
                    return;
                }
            }
            if (rb != rw) {
                System.out.println(0);
                return;
            }
        }
        for (int c = 0; c < n; c++) {
            int cb = 0;
            int cw = 0;
            for (int r = 0; r < n; r++) {
                if (arr[r][c] == 'B')
                    cb++;
                else
                    cw++;
                if (r < n - 2 && arr[r][c] == arr[r + 1][c] && arr[r][c] == arr[r + 2][c]) {
                    System.out.println(0);
                    return;
                }
            }
            if (cb != cw) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }
}