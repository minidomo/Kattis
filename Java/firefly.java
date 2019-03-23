import java.io.*;
import java.util.*;

public class firefly {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        String[] arr = sc.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int h = Integer.parseInt(arr[1]);
        int[] top = new int[n / 2];
        int[] bot = new int[n / 2];
        for (int x = 0; x < n; x++)
            ((x & 1) == 0 ? bot : top)[x / 2] = Integer.parseInt(sc.readLine());
        Arrays.sort(bot);
        Arrays.sort(top);
        int min = n / 2;
        int lvl = 2;
        for (int x = 2; x < h; x++) {
            int lo = 0, hi = n / 2 - 1, hit = 0;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (x <= bot[mid])
                    hi = mid;
                else
                    lo = mid + 1;
            }
            if (x <= bot[lo]) {
                while (lo > 0 && bot[lo - 1] == bot[lo])
                    lo--;
                hit = bot.length - lo;
            }
            lo = 0;
            hi = n / 2 - 1;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (x > h - top[mid])
                    hi = mid;
                else
                    lo = mid + 1;
            }
            if (x > h - top[lo]) {
                while (lo > 0 && top[lo - 1] == top[lo])
                    lo--;
                hit += top.length - lo;
            }
            if (hit < min) {
                lvl = 1;
                min = hit;
            } else if (hit == min)
                lvl++;
        }
        System.out.println(min + " " + lvl);
        sc.close();
    }
}