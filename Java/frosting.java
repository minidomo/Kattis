
// https://open.kattis.com/problems/frosting
import java.util.Scanner;

public class frosting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int side = sc.nextInt();
        long[] ver = new long[side];
        long[] hor = new long[side];

        for (int x = 0; x < side; x++)
            ver[x] = sc.nextLong();

        for (int x = 0; x < side; x++)
            hor[x] = sc.nextLong();

        long[] a = new long[3];
        long[] b = new long[3];

        for (int x = 0; x < side; x++) {
            if (x % 3 == 0) {
                // color 2
                a[0] += ver[x];
                b[0] += hor[x];
            } else if (x % 3 == 1) {
                // color 0
                a[1] += ver[x];
                b[1] += hor[x];
            } else if (x % 3 == 2) {
                // color 1
                a[2] += ver[x];
                b[2] += hor[x];
            }
        }

        long color0 = (a[0] * b[1]) + (a[1] * b[0]) + (a[2] * b[2]);
        long color1 = (a[0] * b[2]) + (a[1] * b[1]) + (a[2] * b[0]);
        long color2 = (a[0] * b[0]) + (a[1] * b[2]) + (a[2] * b[1]);

        System.out.println(color0 + " " + color1 + " " + color2);

        sc.close();
    }
}