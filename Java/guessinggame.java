import java.io.*;
import java.util.*;

public class guessinggame {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        int min = 0, max = 11, num;
        for (;;) {
            num = Integer.parseInt(sc.readLine());
            if (num == 0)
                break;
            String response = sc.readLine();
            if (response.equals("right on")) {
                dc.write(min < num && num < max ? "Stan may be honest\n" : "Stan is dishonest\n");
                min = 0;
                max = 11;
                continue;
            } else if (response.equals("too high"))
                max = Math.min(max, num);
            else
                min = Math.max(min, num);
        }

        dc.close();
        sc.close();
    }
}