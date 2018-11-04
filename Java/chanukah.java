import java.io.*;
import java.util.*;

public class chanukah {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        int cases = Integer.parseInt(sc.readLine());
        while (cases-- > 0) {
            String[] tokens = sc.readLine().split(" ");
            int n = Integer.parseInt(tokens[1]);
            dc.write(tokens[0] + " " + (n * (n + 1) / 2 + n) + "\n");
        }

        dc.close();
        sc.close();
    }
}