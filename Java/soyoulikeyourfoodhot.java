import java.io.*;
import java.util.*;

public class soyoulikeyourfoodhot {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = (int) fix(sc.nextDouble() * 100);
        int a = (int) fix(sc.nextDouble() * 100);
        int b = (int) fix(sc.nextDouble() * 100);
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x = 0; x <= total / b; x++)
            map.put(x * b, x);
        for (int x = 0; x <= total / a; x++) {
            int val = x * a;
            if (map.containsKey(total - val)) {
                count++;
                dc.write(x + " " + map.get(total - val) + "\n");
            }
        }
        if (count == 0)
            dc.write("none\n");
        sc.close();
        dc.close();
    }

    private static double fix(double a) {
        return Math.round(a * 100) / 100d;
    }
}