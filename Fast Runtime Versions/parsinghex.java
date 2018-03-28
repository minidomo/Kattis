
Runtime: 0.07 s
// https://open.kattis.com/problems/parsinghex
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class parsinghex {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        while (sc.ready()) {
            boolean zero = false;
            boolean record = false;
            String hex = "0x";
            for (char c : sc.readLine().toCharArray()) {
                if (!record) {
                    if (c == '0')
                        zero = true;
                    else {
                        if (zero && (c == 'x' || c == 'X')) {
                            record = true;
                            zero = false;
                        } else
                            zero = false;
                    }
                } else {
                    if ((c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F') || (c >= '0' && c <= '9'))
                        hex += "" + c;
                    else {
                        record = false;
                        if (hex.length() > 2) {
                            dc.write(hex + " " + Long.decode(hex) + "\n");
                            hex = "0x";
                        }
                    }
                }
            }
            if (record)
                dc.write(hex + " " + Long.decode(hex) + "\n");
        }
        sc.close();
        dc.flush();
    }
}
