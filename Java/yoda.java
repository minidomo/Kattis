import java.io.*;
import java.util.*;

public class yoda {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        long first = Long.parseLong(sc.readLine());
        long second = Long.parseLong(sc.readLine());
        String a = "", b = "";
        while (first > 0 && second > 0) {
            long dig1 = first % 10, dig2 = second % 10;
            first /= 10;
            second /= 10;
            if (dig1 == dig2) {
                a = dig1 + a;
                b = dig2 + b;
            } else if (dig1 > dig2)
                a = dig1 + a;
            else if (dig1 < dig2)
                b = dig2 + b;
        }
        if (first > 0)
            a = first + a;
        else if (second > 0)
            b = second + b;
        if (a.equals(""))
            a = "YODA";
        else if (!a.equals(""))
            first = Long.parseLong(a);
        if (b.equals(""))
            b = "YODA";
        else if (!b.equals(""))
            second = Long.parseLong(b);
        dc.write((a.equals("YODA") ? a : first + "") + "\n" + (b.equals("YODA") ? b : second + ""));

        dc.close();
        sc.close();
    }
}