import java.io.*;
import java.util.*;

public class costumecontest {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        TreeMap<String, Integer> map = new TreeMap<>();
        int d = sc.nextInt();
        sc.nextLine();
        while (d-- > 0) {
            String line = sc.nextLine();
            if (!map.containsKey(line))
                map.put(line, 0);
            map.put(line, map.get(line) + 1);
        }
        int min = Integer.MAX_VALUE;
        for (int x : map.values())
            if (x < min)
                min = x;
        for (Map.Entry<String, Integer> a : map.entrySet())
            if (a.getValue() == min)
                System.out.println(a.getKey());
        sc.close();
    }
}