import java.io.*;
import java.util.*;

public class vacuumba {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        while (cases-- > 0) {
            int lines = sc.nextInt();
            double x = 0, y = 0;
            double cur = 0;
            while (lines-- > 0) {
                double angle = -sc.nextDouble();
                double dist = sc.nextDouble();
                cur += angle;
                x += dist * Math.sin(Math.toRadians(cur));
                y += dist * Math.cos(Math.toRadians(cur));
            }
            System.out.printf("%.6f %.6f\n", x, y);
        }
        sc.close();
    }
}