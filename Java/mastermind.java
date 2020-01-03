import java.io.*;
import java.util.*;

public class mastermind {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int[] q = new int['Z' + 1];
        int[] w = new int['Z' + 1];
        int n = sc.nextInt();
        char[] a = sc.next().toCharArray();
        char[] b = sc.next().toCharArray();
        int r = 0;
        int s = 0;
        for (int x = 0; x < n; x++) {
            if (a[x] == b[x])
                r++;
            else {
                q[a[x]]++;
                w[b[x]]++;
            }
        }
        for (int x = 'A'; x <= 'Z'; x++)
            s += Math.min(q[x], w[x]);
        System.out.println(r + " " + s);
    }
}