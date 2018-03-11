
// Runtime: 0.53 s
// https://open.kattis.com/problems/shatteredcake
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class shatteredcake {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        OutputStream dc = new BufferedOutputStream(System.out);

        int width = Integer.parseInt(sc.readLine());
        int pieces = Integer.parseInt(sc.readLine());
        int area = 0;
        while (pieces-- > 0) {
            String w = sc.readLine();
            int s = w.indexOf(' ');
            area += Integer.parseInt(w.substring(0, s)) * Integer.parseInt(w.substring(s + 1));
        }
        dc.write(((area / width) + "\n").getBytes());

        sc.close();
        dc.flush();
    }
}
