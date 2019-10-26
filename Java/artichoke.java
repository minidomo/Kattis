import java.io.*;
import java.util.*;

public class artichoke {
    static int p, a, b, c, d, n;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        p = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();
        n = sc.nextInt();
        double min = Integer.MAX_VALUE;
        double max = Integer.MIN_VALUE;
        double dist = 0;
        for (int x = 1; x <= n; x++) {
            double cur = price(x);
            if (cur > max) {
                dist = Math.max(dist, max - min);
                max = cur;
                min = max;
            } else {
                min = Math.min(min, cur);
            }
        }
        dist = Math.max(dist, max - min);
        System.out.println(dist);
    }

    static double price(int k) {
        return p * (Math.sin(a * k + b) + Math.cos(c * k + d) + 2);
    }
}