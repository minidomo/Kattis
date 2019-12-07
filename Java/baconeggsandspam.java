import java.io.*;
import java.util.*;

public class baconeggsandspam {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        for (;;) {
            int n = sc.nextInt();
            if (n == 0)
                break;
            TreeMap<String, TreeSet<String>> map = new TreeMap<>();
            for (int x = 0; x < n; x++) {
                String name = sc.next();
                String[] list = sc.nextLine().trim().split(" ");
                for (String s : list) {
                    TreeSet<String> set = map.get(s);
                    if (set == null)
                        map.put(s, set = new TreeSet<>());
                    set.add(name);
                }
            }
            for (String key : map.keySet()) {
                System.out.print(key + " ");
                for (String val : map.get(key))
                    System.out.print(val + " ");
                System.out.println();
            }
            System.out.println();
        }
    }
}