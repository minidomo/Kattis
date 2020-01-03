import java.io.*;
import java.util.*;

public class palindromicpassword {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> set = new TreeSet<>();
        for (int x = 100; x <= 999; x++) {
            int n = x;
            int a = x;
            while (a > 0) {
                int d = a % 10;
                n = n * 10 + d;
                a = (a - d) / 10;
            }
            set.add(n);
        }
        int n = sc.nextInt();
        while (n-- > 0) {
            int x = sc.nextInt();
            Integer a = set.floor(x);
            Integer b = set.ceiling(x);
            if (a == null)
                System.out.println(b);
            else if (b == null)
                System.out.println(a);
            else {
                int d1 = Math.abs(x - a);
                int d2 = Math.abs(x - b);
                if (d1 < d2)
                    System.out.println(a);
                else if (d2 < d1)
                    System.out.println(b);
                else
                    System.out.println(a);
            }
        }
    }
}