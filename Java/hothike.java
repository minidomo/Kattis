import java.io.*;
import java.util.*;

public class hothike {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int x = 0; x < n; x++)
            arr[x] = sc.nextInt();
        int t = Integer.MAX_VALUE;
        int d = 0;
        for (int x = 0; x < n - 2; x++)
            if (Math.max(arr[x], arr[x + 2]) < t) {
                t = Math.max(arr[x], arr[x + 2]);
                d = x + 1;
            }
        System.out.println(d + " " + t);
    }
}