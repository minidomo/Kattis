
// https://open.kattis.com/problems/bus

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bus {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        int cases = Integer.parseInt(sc.readLine());
        while (cases-- > 0) {
            int times = Integer.parseInt(sc.readLine());
            double sum = 0;
            for (int x = 0; x < times; x++)
                sum = 2 * (sum + .5);
            dc.write((int) sum + "\n");
        }

        dc.flush();
        dc.close();
        sc.close();
    }
}