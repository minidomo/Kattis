import java.io.*;
import java.util.*;

public class teacherevaluation {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        if (p == 100) {
            System.out.println("impossible");
            return;
        }
        int sum = 0;
        for (int x = 0; x < n; x++)
            sum += sc.nextInt();
        long lo = n + 1;
        long hi = (int) 1e6;
        long ans = 0;
        while (lo < hi) {
            long m = (lo + hi) / 2;
            long add = m - n;
            long total = add * 100 + sum;
            if (total / (double) m >= p) {
                ans = add;
                hi = m;
            } else {
                lo = m + 1;
            }
        }
        System.out.println(ans);
    }
}