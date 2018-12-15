import java.io.*;
import java.util.*;

public class scrollingsign {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        while (cases-- > 0) {
            sc.nextInt();
            int words = sc.nextInt();
            int total = 0, count = 0;
            String word = "";
            while (words-- > 0) {
                if (word.length() == 0) {
                    word = sc.next();
                    total += word.length();
                } else {
                    String s = sc.next();
                    total += s.length();
                    int c = 0;
                    for (int x = word.length() - 1, a = 1; x >= 0 && a <= s.length(); x--, a++) {
                        String sub1 = word.substring(x);
                        String sub2 = s.substring(0, a);
                        if (sub1.equals(sub2))
                            c = sub1.length();
                    }
                    count += c;
                    word = s;
                }
            }
            System.out.println(total - count);
        }
        sc.close();
    }
}