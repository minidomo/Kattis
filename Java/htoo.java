import java.io.*;
import java.util.*;

public class htoo {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        HashMap<Character, Integer> first = new HashMap<>();
        HashMap<Character, Integer> sec = new HashMap<>();
        String[] arr = sc.readLine().split(" ");
        getValues(first, arr[0]);
        int mul = Integer.parseInt(arr[1]);
        for (Map.Entry<Character, Integer> a : first.entrySet())
            first.put(a.getKey(), a.getValue() * mul);
        getValues(sec, sc.readLine());
        int min = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> a : sec.entrySet()) {
            if (!first.containsKey(a.getKey())) {
                min = Integer.MAX_VALUE;
                break;
            }
            min = Math.min(min, first.get(a.getKey()) / a.getValue());
        }
        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }

    private static void getValues(HashMap<Character, Integer> map, String s) {
        char prev = '-';
        int num = 0;
        for (char c : s.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                map.put(prev, map.containsKey(prev) ? map.get(prev) + Math.max(1, num) : Math.max(1, num));
                num = 0;
                prev = c;
            } else {
                if (num == 0)
                    num = c - '0';
                else
                    num = num * 10 + (c - '0');
            }
        }
        map.put(prev, map.containsKey(prev) ? map.get(prev) + Math.max(1, num) : Math.max(1, num));
        map.remove('-');
    }
}