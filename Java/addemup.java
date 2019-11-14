import java.io.*;
import java.util.*;

public class addemup {
    static int[] flip = { 0, 1, 2, -1, -1, 5, 9, -1, 8, 6 };
    static int n, s;
    static int[] nums, alt;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();
        nums = new int[n];
        alt = new int[n];
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int x = 0; x < n; x++) {
            int a = sc.nextInt();
            HashSet<Integer> set = map.get(a);
            if (set == null)
                map.put(a, set = new HashSet<>());
            set.add(x);
            nums[x] = a;
            int flipped = fl(a);
            alt[x] = flipped;
            if (flipped != -1 && flipped != a) {
                set = map.get(flipped);
                if (set == null)
                    map.put(flipped, set = new HashSet<>());
                set.add(x);
            }
        }
        for (int x = 0; x < n; x++) {
            int a = nums[x];
            int flipped = alt[x];
            int need = s - a;
            HashSet<Integer> set = map.get(need);
            if (set != null) {
                set = new HashSet<>(set);
                set.remove(x);
                if (set.size() > 0) {
                    System.out.println("YES");
                    return;
                }
            }
            if (flipped != -1) {
                need = s - flipped;
                set = map.get(need);
                if (set != null) {
                    set = new HashSet<>(set);
                    set.remove(x);
                    if (set.size() > 0) {
                        System.out.println("YES");
                        return;
                    }
                }
            }
        }
        System.out.println("NO");
        return;
    }

    static int fl(int a) {
        int ret = 0;
        while (a > 0) {
            int d = a % 10;
            if (flip[d] == -1)
                return -1;
            ret = flip[d] + ret * 10;
            a /= 10;
        }
        return ret;
    }
}