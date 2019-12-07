import java.io.*;
import java.util.*;

public class program {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String[] tokens = sc.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]);
        int k = Integer.parseInt(tokens[1]);
        long[] arr = new long[n + 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        tokens = sc.readLine().split(" ");
        for (String s : tokens) {
            int x = Integer.parseInt(s);
            map.put(x, map.containsKey(x) ? map.get(x) + 1 : 1);
        }
        for (int key : map.keySet()) {
            int val = map.get(key);
            for (int x = key; x <= n; x += key)
                arr[x] += val;
        }
        arr[0] = k;
        for (int x = 1; x <= n; x++)
            arr[x] += arr[x - 1];
        int q = Integer.parseInt(sc.readLine());
        while (q-- > 0) {
            tokens = sc.readLine().split(" ");
            int l = Integer.parseInt(tokens[0]);
            int r = Integer.parseInt(tokens[1]);
            if (l == 0)
                out.println(arr[r]);
            else
                out.println(arr[r] - arr[l - 1]);
        }
        out.close();
    }
}