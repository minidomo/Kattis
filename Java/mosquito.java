import java.util.*;
import java.io.*;

public class mosquito {
    static int M, P, L, E, R, S, N;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            M = sc.nextInt();
            P = sc.nextInt();
            L = sc.nextInt();
            E = sc.nextInt();
            R = sc.nextInt();
            S = sc.nextInt();
            N = sc.nextInt();
            while (N-- > 0) {
                int p = L / R;
                int m = P / S;
                int l = M * E;
                L = l;
                P = p;
                M = m;
            }
            System.out.println(M);
        }
    }
}