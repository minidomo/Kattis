import java.util.*;

public class taisformula {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt() - 1;
        double total = 0, t0 = sc.nextDouble(), v0 = sc.nextDouble();
        while (n-- > 0) {
            double t = sc.nextDouble(), v = sc.nextDouble();
            total += (v + v0) / 2 * ((t - t0) / 1000);
            t0 = t;
            v0 = v;
        }
        System.out.println(total);
        sc.close();
    }
}