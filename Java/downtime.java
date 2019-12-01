import java.io.*;
import java.util.*;

public class downtime {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[101001];
        int n = sc.nextInt();
        int k = sc.nextInt();
        while (n-- > 0) {
            int a = sc.nextInt();
            arr[a]++;
            arr[a + 1000]--;
        }
        double max = 0;
        for (int x = 1; x < arr.length; x++)
            max = Math.max(max, arr[x] += arr[x - 1]);
        System.out.println((int) Math.ceil(max / k));
    }
}