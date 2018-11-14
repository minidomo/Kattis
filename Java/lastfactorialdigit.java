import java.io.*;
import java.util.*;

public class lastfactorialdigit {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[11];
        arr[1] = 1;
        for (int x = 2; x < arr.length; x++)
            arr[x] = ((arr[x - 1] % 10) * (x % 10)) % 10;

        int cases = Integer.parseInt(sc.readLine());
        while (cases-- > 0)
            dc.write(arr[Integer.parseInt(sc.readLine())] + "\n");

        dc.close();
        sc.close();
    }
}