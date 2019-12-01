import java.io.*;
import java.util.*;

public class supercomputer {
    static int n;
    static int[] arr;
    static boolean[] state;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int k = sc.nextInt();
        arr = new int[n + 1];
        state = new boolean[n + 1];
        while (k-- > 0) {
            char q = sc.next().charAt(0);
            if (q == 'F') {
                int x = sc.nextInt();
                state[x] = !state[x];
                upd(x, state[x] ? 1 : -1);
            } else {
                int l = sc.nextInt();
                int r = sc.nextInt();
                System.out.println(qry(r) - qry(l - 1));
            }
        }
    }

    static void upd(int i, int val) {
        for (; i <= n; i += i & -i)
            arr[i] += val;
    }

    static int qry(int i) {
        int sum = 0;
        for (; i > 0; i -= i & -i)
            sum += arr[i];
        return sum;
    }
}