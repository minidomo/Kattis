import java.io.*;
import java.util.*;

public class election {
    static int MAX = 50;
    static int n, v1, v2, w;
    static long[][][] state;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            state = new long[MAX + 1][MAX + 1][MAX + 1];
            for (long[][] r : state)
                for (long[] c : r)
                    Arrays.fill(c, -1);
            n = sc.nextInt();
            v1 = sc.nextInt();
            v2 = sc.nextInt();
            w = sc.nextInt();
            int leftover = n - v1 - v2;
            long wins = rec(v1, v2, leftover);
            long count = 1L << leftover;
            double res = wins * 100d / count;
            if (res > w)
                System.out.println("GET A CRATE OF CHAMPAGNE FROM THE BASEMENT!");
            else if (res == 0)
                System.out.println("RECOUNT!");
            else
                System.out.println("PATIENCE, EVERYONE!");
        }
    }

    static long rec(int a, int b, int leftover) {
        if (state[a][b][leftover] != -1)
            return state[a][b][leftover];
        if (leftover == 0) {
            if (a > n / 2)
                return state[a][b][leftover] = 1;
            return state[a][b][leftover] = 0;
        } else {
            long l = state[a + 1][b][leftover - 1] = rec(a + 1, b, leftover - 1);
            long r = state[a][b + 1][leftover - 1] = rec(a, b + 1, leftover - 1);
            return state[a][b][leftover] = l + r;
        }
    }
}