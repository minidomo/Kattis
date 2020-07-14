import java.io.*;
import java.util.*;

public class perket {
    static int n;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][2];
        for (int x = 0; x < n; x++) {
            arr[x][0] = sc.nextInt();
            arr[x][1] = sc.nextInt();
        }
        System.out.println(rec(0, 1, 0));
    }

    static int rec(int index, int res1, int res2) {
        if (index == n)
            return res1 == 1 && res2 == 0 ? Integer.MAX_VALUE : Math.abs(res1 - res2);
        return Math.min(rec(index + 1, res1 * arr[index][0], res2 + arr[index][1]), rec(index + 1, res1, res2));
    }
}