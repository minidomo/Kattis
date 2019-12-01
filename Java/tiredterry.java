import java.io.*;
import java.util.*;

public class tiredterry {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int d = sc.nextInt();
        String s = sc.next();
        int[] arr = new int[n << 1];
        for (int x = 0; x < arr.length; x++)
            if (s.charAt(x % n) == 'Z')
                arr[x]++;
        for (int x = 1; x < arr.length; x++)
            arr[x] += arr[x - 1];
        int count = 0;
        for (int x = n; x < arr.length; x++)
            if (arr[x] - arr[x - p] < d)
                count++;
        System.out.println(count);
    }
}