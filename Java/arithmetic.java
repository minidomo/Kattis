import java.io.*;
import java.util.*;

public class arithmetic {
    public static void main(String[] args) throws Exception {
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        String s = new BufferedReader(new InputStreamReader(System.in), 1 << 16).readLine();
        if (s.equals("0"))
            dc.write('0');
        else {
            StringBuilder res = new StringBuilder();
            int num = 0;
            int shift = 0;
            for (int x = s.length() - 1; x >= 0; x--) {
                int cur = s.charAt(x) - '0';
                num += cur << shift;
                shift += 3;
                if (shift >= 4) {
                    int dig = num & 15;
                    if (dig > 9)
                        res.insert(0, (char) (dig - 10 + 'A'));
                    else
                        res.insert(0, dig);
                    num >>= 4;
                    shift -= 4;
                }
            }
            if (num != 0)
                if (num > 9)
                    res.insert(0, (char) (num - 10 + 'A'));
                else
                    res.insert(0, num);
            dc.write(res.toString() + "\n");
        }
        dc.close();
    }
}