
// Runtime: 0.06 s
// https://open.kattis.com/problems/tolower
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class tolower {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        OutputStream dc = new BufferedOutputStream(System.out);

        String q = sc.readLine();
        int space = q.indexOf(' ');
        int problems = Integer.parseInt(q.substring(0, space));
        int cases = Integer.parseInt(q.substring(space + 1));
        int max = problems;
        for (int x = 0; x < problems; x++) {
            boolean moreUpper = false;
            for (int a = 0; a < cases; a++) {
                String line = sc.readLine();
                if (!moreUpper) {
                    char[] chars = line.toCharArray();
                    for (int s = 1; s < chars.length; s++) {
                        if (Character.isUpperCase(chars[s])) {
                            moreUpper = true;
                            break;
                        }
                    }
                }
            }
            if (moreUpper)
                max--;
        }
        dc.write((max + "\n").getBytes());
        sc.close();
        dc.flush();
    }
}
