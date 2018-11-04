import java.io.*;
import java.util.*;

public class eulersnumber {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(sc.readLine());
        double sum = 1, prev = 1;
        for (int x = 1; x <= n; x++)
            sum += prev *= 1d / x;
        dc.write(sum + "\n");

        dc.close();
        sc.close();
    }
}