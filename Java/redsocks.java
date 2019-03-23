import java.io.*;
import java.util.*;
import java.math.*;

public class redsocks {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        TreeMap<Long, Long> map = new TreeMap<>();
        for (long x = 2; x <= 50000; x++)
            map.put(x * x - x, x);
        for (;;) {
            String[] line = sc.readLine().split(" ");
            long p = Long.parseLong(line[0]);
            long q = Long.parseLong(line[1]);
            if (p == 0 && q == 0)
                break;
            if (p == 0)
                dc.write("0 2\n");
            else if (p == q)
                dc.write("2 0\n");
            else {
                // p with total
                // q with red
                long gcd = gcd(p, q);
                p /= gcd;
                q /= gcd;
                long cmn = 0;
                for (long x : map.keySet()) {
                    double m = (double) p * x / q;
                    if ((long) m != m)
                        continue;
                    if (map.containsKey((long) m)) {
                        cmn = p * x;
                        break;
                    }
                }
                if (cmn == 0)
                    dc.write("impossible\n");
                else {
                    long red = map.get(cmn / q);
                    long total = map.get(cmn / p);
                    dc.write(red + " " + (total - red) + "\n");
                }
            }
        }
        dc.close();
        sc.close();
    }

    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}