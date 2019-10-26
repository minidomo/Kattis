import java.io.*;
import java.util.*;

public class digits {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        for (;;) {
            String line = sc.next();
            if (line.equals("END"))
                break;
            if (line.equals("1")) {
                System.out.println(1);
                continue;
            }
            int i = 2;
            int prev = line.length();
            int cur = (int) Math.log10(prev) + 1;
            while (cur != prev) {
                prev = cur;
                cur = (int) Math.log10(prev) + 1;
                i++;
            }
            System.out.println(i);
        }
    }
}