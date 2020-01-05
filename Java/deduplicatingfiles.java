import java.io.*;
import java.util.*;

public class deduplicatingfiles {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        for (;;) {
            int n = Integer.parseInt(sc.readLine());
            if (n == 0)
                break;
            HashSet<String> set = new HashSet<>();
            String[] arr = new String[n];
            int[] codes = new int[n];
            for (int x = 0; x < n; x++) {
                arr[x] = sc.readLine();
                codes[x] = hash(arr[x]);
                set.add(arr[x]);
            }
            int count = 0;
            for (int a = 0; a < arr.length - 1; a++)
                for (int b = a + 1; b < arr.length; b++)
                    if (codes[a] == codes[b] && !arr[a].equals(arr[b]))
                        count++;
            ans.append(set.size()).append(' ').append(count).append('\n');
        }
        System.out.print(ans);
    }

    static int hash(String s) {
        int h = s.charAt(0);
        for (int x = 1; x < s.length(); x++)
            h ^= s.charAt(x);
        return h;
    }
}