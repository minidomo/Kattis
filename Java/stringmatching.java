import java.io.*;
import java.util.*;

public class stringmatching {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder ans = new StringBuilder();
        while (sc.hasNextLine()) {
            String b = sc.nextLine();
            String a = sc.nextLine();
            int[] lps = getLPS(b);
            int i = 0, j = 0;
            while (i < a.length()) {
                if (a.charAt(i) == b.charAt(j)) {
                    i++;
                    j++;
                }
                if (j == b.length()) {
                    ans.append(i - j).append(' ');
                    j = lps[j - 1];
                } else if (i < a.length() && a.charAt(i) != b.charAt(j)) {
                    if (j > 0)
                        j = lps[j - 1];
                    else
                        i++;
                }
            }
            ans.append('\n');
        }
        System.out.println(ans);
    }

    static int[] getLPS(String a) {
        int[] arr = new int[a.length()];
        int x = 1, len = 0;
        while (x < a.length()) {
            if (a.charAt(x) == a.charAt(len)) {
                arr[x++] = ++len;
            } else {
                if (len > 0)
                    len = arr[len - 1];
                else
                    arr[x++] = len;
            }
        }
        return arr;
    }
}