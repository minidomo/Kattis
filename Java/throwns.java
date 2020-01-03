import java.io.*;
import java.util.*;

public class throwns {
    static int n;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int k = sc.nextInt();
        Stack<Integer> s = new Stack<>();
        int cur = 0;
        while (k-- > 0) {
            String a = sc.next();
            if (a.matches("-?\\d+")) {
                int q = Integer.parseInt(a);
                s.push(q);
                cur += q;
            } else {
                int t = sc.nextInt();
                while (t-- > 0)
                    cur -= s.pop();
            }
        }
        System.out.println(mod(cur));
    }

    static int mod(int a) {
        while (a < 0)
            a += n;
        a %= n;
        return a;
    }
}