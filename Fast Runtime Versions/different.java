
// Runtime: 0.05 s
// https://open.kattis.com/problems/different
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class different {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        OutputStream dc = new BufferedOutputStream(System.out);

        while (sc.ready()) {
            String s = sc.readLine();
            int space = s.indexOf(' ');
            dc.write((Math.abs(Long.parseLong(s.substring(0, space)) - Long.parseLong(s.substring(space + 1))) + "\n")
                    .getBytes());
        }

        sc.close();
        dc.flush();
    }
}
