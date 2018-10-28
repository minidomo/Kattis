import java.io.*;
import java.util.*;

public class racingalphabet {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        final String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ '";

        int cases = Integer.parseInt(sc.readLine());
        while (cases-- > 0) {
            String line = sc.readLine();
            double sum = 0;
            for (int x = 1, prev = alpha.indexOf(line.charAt(0)); x < line.length(); x++) {
                int loc = alpha.indexOf(line.charAt(x));
                int dist1 = Math.abs(prev - loc);
                int dist2 = 28 - dist1;
                sum += Math.min(dist1, dist2);
                prev = loc;
            }
            dc.write(Math.PI * sum / 7 + line.length() + "\n");
        }

        dc.close();
        sc.close();
    }
}