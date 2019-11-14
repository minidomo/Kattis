import java.io.*;
import java.util.*;

public class softpasswords {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String p = sc.next();
        if (s.equals(p)) {
            System.out.println("Yes");
        } else {
            char last = s.charAt(s.length() - 1);
            char first = s.charAt(0);
            String opp = "";
            for (int x = 0; x < s.length(); x++) {
                char cur = s.charAt(x);
                if (Character.isLetter(cur))
                    if (Character.isUpperCase(cur))
                        opp += Character.toLowerCase(cur);
                    else
                        opp += Character.toUpperCase(cur);
                else
                    opp += cur;
            }
            if (opp.equals(p)) {
                System.out.println("Yes");
            } else {
                String a = first + p;
                String b = p + last;
                if (a.equals(s) && Character.isDigit(first))
                    System.out.println("Yes");
                else if (b.equals(s) && Character.isDigit(last))
                    System.out.println("Yes");
                else
                    System.out.println("No");
            }
        }
    }
}
