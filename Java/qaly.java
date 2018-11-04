import java.util.*;
import java.io.*;

public class qaly {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        int cases = Integer.parseInt(sc.readLine());
        double sum = 0;
        while (cases-- > 0) {
            String[] tokens = sc.readLine().split(" ");
            sum += Double.parseDouble(tokens[0]) * Double.parseDouble(tokens[1]);
        }
        dc.write(sum + "\n");

        dc.close();
        sc.close();
    }
}