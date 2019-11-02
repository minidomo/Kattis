import java.util.*;
import java.io.*;

public class integerdivision {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        HashMap<Integer, Long> map = new HashMap<>();
        while (n-- > 0) {
            int a = sc.nextInt() / d;
            map.put(a, map.containsKey(a) ? map.get(a) + 1 : 1L);
        }
        long count = 0;
        for (int k : map.keySet()) {
            long v = map.get(k);
            count += v * (v - 1) / 2;
        }
        System.out.println(count);
    }
}