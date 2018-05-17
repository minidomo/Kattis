
// Runtime: 0.20 s
// https://open.kattis.com/problems/frosting
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class frosting {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        OutputStream dc = new BufferedOutputStream(System.out);

        int side = Integer.parseInt(sc.readLine());
        String[] ver = sc.readLine().split(" ");
        String[] hor = sc.readLine().split(" ");

        long[] a = new long[3];
        long[] b = new long[3];

        for (int x = 0; x < side; x++) {
            if (x % 3 == 0) {
                // color 2
                a[0] += Long.parseLong(ver[x]);
                b[0] += Long.parseLong(hor[x]);
            } else if (x % 3 == 1) {
                // color 0
                a[1] += Long.parseLong(ver[x]);
                b[1] += Long.parseLong(hor[x]);
            } else if (x % 3 == 2) {
                // color 1
                a[2] += Long.parseLong(ver[x]);
                b[2] += Long.parseLong(hor[x]);
            }
        }

        long color0 = (a[0] * b[1]) + (a[1] * b[0]) + (a[2] * b[2]);
        long color1 = (a[0] * b[2]) + (a[1] * b[1]) + (a[2] * b[0]);
        long color2 = (a[0] * b[0]) + (a[1] * b[2]) + (a[2] * b[1]);
        
        dc.write((color0 + " " + color1 + " " + color2).getBytes());

        sc.close();
        dc.flush();
    }
}
