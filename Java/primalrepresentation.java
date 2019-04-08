import java.io.*;
import java.util.*;

public class primalrepresentation {

    private static TreeMap<Integer, Integer> map;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder ans = new StringBuilder();
        while (sc.hasNextInt()) {
            int num = sc.nextInt();
            if (num < 0) {
                ans.append("-1 ");
                num *= -1;
            }
            getFactors(num);
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                int a = e.getKey();
                int b = e.getValue();
                ans.append(a);
                if (b > 1)
                    ans.append('^').append(b);
                ans.append(' ');
            }
            ans.append('\n');
        }
        System.out.println(ans);
        sc.close();
    }

    private static void getFactors(int num) {
        map = new TreeMap<>();
        if ((num & 1) == 0) {
            int c = 0;
            while ((num & 1) == 0) {
                num >>= 1;
                c++;
            }
            map.put(2, c);
        }
        for (int x = 3; x <= Math.sqrt(num); x += 2)
            if (num % x == 0) {
                int c = 0;
                while (num % x == 0) {
                    num /= x;
                    c++;
                }
                map.put(x, c);
            }
        if (num > 2)
            map.put(num, 1);
    }
}