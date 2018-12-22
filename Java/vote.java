import java.io.*;
import java.util.*;

public class vote {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        while (cases-- > 0) {
            int size = sc.nextInt();
            int total = 0;
            int max = 0;
            int[] arr = new int[size];
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int x = 0; x < size; x++) {
                total += arr[x] = sc.nextInt();
                max = Math.max(max, arr[x]);
                map.put(arr[x], map.containsKey(arr[x]) ? map.get(arr[x]) + 1 : 1);
            }
            if (map.get(max) > 1) {
                System.out.println("no winner");
                continue;
            }
            for (int x = 0; x < size; x++)
                if (arr[x] == max) {
                    System.out.println((max > total / 2d ? "majority " : "minority ") + "winner " + (x + 1));
                    break;
                }
        }
        sc.close();
    }
}