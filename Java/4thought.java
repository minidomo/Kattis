import java.io.*;
import java.util.*;

public class 4thought {
    public static void main(String[] args) throws Exception {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "4 / 4 / 4 / 4");
        map.put(-1, "4 - 4 / 4 - 4");
        map.put(32, "4 * 4 + 4 * 4");
        map.put(256, "4 * 4 * 4 * 4");
        map.put(1, "4 / 4 * 4 / 4");
        map.put(2, "4 / 4 + 4 / 4");
        map.put(-4, "4 / 4 / 4 - 4");
        map.put(68, "4 * 4 * 4 + 4");
        map.put(4, "4 / 4 / 4 + 4");
        map.put(-7, "4 / 4 - 4 - 4");
        map.put(-8, "4 - 4 * 4 + 4");
        map.put(7, "4 - 4 / 4 + 4");
        map.put(8, "4 / 4 * 4 + 4");
        map.put(9, "4 / 4 + 4 + 4");
        map.put(-15, "4 / 4 - 4 * 4");
        map.put(-16, "4 - 4 * 4 - 4");
        map.put(15, "4 * 4 - 4 / 4");
        map.put(16, "4 / 4 * 4 * 4");
        map.put(17, "4 / 4 + 4 * 4");
        map.put(24, "4 * 4 + 4 + 4");
        map.put(-60, "4 - 4 * 4 * 4");
        map.put(60, "4 * 4 * 4 - 4");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int x = sc.nextInt();
            if (map.containsKey(x))
                System.out.println(map.get(x) + " = " + x);
            else
                System.out.println("no solution");
        }
    }
}