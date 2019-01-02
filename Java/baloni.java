import java.io.*;
import java.util.*;

public class baloni {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        int n = Integer.parseInt(sc.readLine());
        HashMap<Integer, TreeSet<Integer>> map = new HashMap<>();
        TreeSet<Integer> indexes = new TreeSet<>();
        int[] arr = new int[n];
        int i = 0;
        for (String s : sc.readLine().split(" ")) {
            indexes.add(i);
            arr[i] = Integer.parseInt(s);
            if (!map.containsKey(arr[i]))
                map.put(arr[i], new TreeSet<>());
            map.get(arr[i]).add(i);
            i++;
        }
        int count = 0;
        while (!indexes.isEmpty()) {
            int idx = indexes.pollFirst();
            int cur = arr[idx];
            while (map.containsKey(cur - 1)) {
                Integer a = map.get(cur - 1).higher(idx);
                if (a != null) {
                    map.get(cur - 1).remove(a);
                    cur--;
                    idx = a.intValue();
                    indexes.remove(idx);
                } else
                    break;
            }
            count++;
        }
        System.out.println(count);
        sc.close();
    }
}