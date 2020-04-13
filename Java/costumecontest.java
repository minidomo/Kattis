import java.io.*;
import java.util.*;

public class costumecontest {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeMap<String, Integer> map = new TreeMap<>();
        while (n-- > 0) {
            String s = sc.next();
            map.put(s, map.containsKey(s) ? map.get(s) + 1 : 1);
        }
        int min = 10000;
        for (String key : map.keySet())
            min = Math.min(min, map.get(key));
        for (String key : map.keySet())
            if (map.get(key) == min)
                System.out.println(key);
    }
}