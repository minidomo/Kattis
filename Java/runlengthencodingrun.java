import java.io.*;
import java.util.*;

public class runlengthencodingrun {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] tokens = sc.readLine().split(" ");
        if (tokens[0].equals("E")) {
            int count = 0;
            char current = tokens[1].charAt(0);
            for (char c : tokens[1].toCharArray()) {
                if (c == current)
                    count++;
                else {
                    dc.write(current + "" + count);
                    current = c;
                    count = 1;
                }
            }
            dc.write(current + "" + count);
        } else {
            for (int x = 0; x < tokens[1].length() - 1; x += 2) {
                char c = tokens[1].charAt(x);
                int count = tokens[1].charAt(x + 1) - '0';
                for (int a = 0; a < count; a++)
                    dc.write(c);
            }
        }

        dc.close();
        sc.close();
    }
}