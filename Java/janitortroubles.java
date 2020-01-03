import java.io.*;
import java.util.*;

public class janitortroubles {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        double s = 0;
        int[] a = new int[4];
        for (int x = 0; x < 4; x++) {
            a[x] = sc.nextInt();
            s += a[x];
        }
        s /= 2;
        double res = 1;
        for (int x = 0; x < 4; x++)
            res *= s - a[x];
        System.out.println(Math.sqrt(res));
    }
}