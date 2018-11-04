import java.io.*;
import java.util.*;

public class sumsquareddigits {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        int cases = Integer.parseInt(sc.readLine());
        while (cases-- > 0) {
            String[] tokens = sc.readLine().split(" ");
            int base = Integer.parseInt(tokens[1]);
            long num = Long.parseLong(tokens[2]);
            long sum = 0;
            while (num > 0) {
                int dig = (int) num % base;
                sum += dig * dig;
                num = (num - dig) / base;
            }
            dc.write(tokens[0] + " " + sum + "\n");
        }

        dc.close();
        sc.close();
    }
}