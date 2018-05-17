
// Runtime: 0.07 s
// https://open.kattis.com/problems/mixedfractions
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class mixedfractions {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        OutputStream dc = new BufferedOutputStream(System.out);

        while (true) {
            String s = sc.readLine();
            int i = s.indexOf(' ');
            double n = Double.parseDouble(s.substring(0, i));
            double d = Double.parseDouble(s.substring(i + 1));
            if (n == 0 && d == 0)
                break;
            dc.write((d > n ? "0 " + (int) n + " / " + (int) d + "\n"
                    : (int) (n / d) + " " + (int) (n % d) + " / " + (int) d + "\n").getBytes());
        }

        sc.close();
        dc.flush();
    }
}
