
// Runtime: 0.18 s
// https://open.kattis.com/problems/inversefactorial
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class repeatingdecimal {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        // long division
        while (sc.ready()) {
            String s = sc.readLine();
            int space1 = s.indexOf(' ');
            int space2 = s.lastIndexOf(' ');
            int a = Integer.parseInt(s.substring(0, space1));
            int b = Integer.parseInt(s.substring(space1 + 1, space2));
            int c = Integer.parseInt(s.substring(space2 + 1));
            dc.write("0.");
            while (c-- > 0) {
                a *= 10;
                dc.write((a / b) + "");
                a %= b;
            }
            dc.write("\n");
        }
        sc.close();
        dc.flush();
    }
}
