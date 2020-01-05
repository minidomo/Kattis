import java.io.*;
import java.util.*;

public class epigdanceoff {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[m];
        for (int x = 0; x < n; x++) {
            char[] line = sc.next().toCharArray();
            for (int a = 0; a < m; a++)
                if (line[a] == '_')
                    arr[a]++;
        }
        int count = 0;
        for (int x : arr)
            if (x == n)
                count++;
        System.out.println(count + 1);
    }
}