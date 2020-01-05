import java.io.*;
import java.util.*;

public class apples {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        char[][] arr = new char[R][C];
        for (int r = 0; r < R; r++)
            arr[r] = sc.next().toCharArray();
        for (int c = 0; c < C; c++) {
            int available = 0;
            for (int r = R - 1; r >= 0; r--) {
                if (arr[r][c] == '.')
                    available++;
                else if (arr[r][c] == '#')
                    available = 0;
                else if (available > 0) {
                    arr[r][c] = '.';
                    arr[r + available][c] = 'a';
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        for (char[] r : arr) {
            for (char c : r)
                ans.append(c);
            ans.append('\n');
        }
        System.out.println(ans);
    }
}