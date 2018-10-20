import java.io.*;
import java.util.*;

public class fridge {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int x = 0; x < 10; x++)
            map.put(x, 0);
        for (char c : sc.readLine().toCharArray()) {
            int num = c - '0';
            map.put(num, map.get(num) + 1);
        }

        boolean done = false;
        for (Map.Entry<Integer, Integer> s : map.entrySet())
            if (s.getValue() == 0 && s.getKey() != 0) {
                dc.write(s.getKey() + "\n");
                done = true;
                break;
            }

        if (!done) {
            if (map.get(0) == 0)
                dc.write("10\n");
            else {
                int minKey = 0, minVal = Integer.MAX_VALUE;
                for (Map.Entry<Integer, Integer> a : map.entrySet())
                    if (a.getKey() != 0 && a.getValue() < minVal) {
                        minKey = a.getKey();
                        minVal = a.getValue();
                    }
                dc.write(minKey + "");
                map.put(minKey, map.get(minKey) - 1);
                if (map.get(0) <= map.get(minKey))
                    minKey = 0;
                while (map.get(minKey) >= 0) {
                    dc.write(minKey + "");
                    map.put(minKey, map.get(minKey) - 1);
                }
            }
        }

        dc.close();
        sc.close();
    }
}