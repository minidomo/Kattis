import java.io.*;
import java.util.*;

public class islands {
    public static void main(String args[]) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        int cases = Integer.parseInt(sc.readLine());
        while (cases-- > 0) {
            String[] tokens = sc.readLine().split(" ");
            int[] arr = new int[12];
            int count = 0, max = 0;
            for (int x = 1; x < tokens.length; x++) {
                int num = Integer.parseInt(tokens[x]);
                if (num > max)
                    max = num;
                arr[x - 1] = num;
            }
            while (max != 0) {
                int sub = 0;
                for (int x = 0, prev = -1; x < arr.length; x++) {
                    if (arr[x] < max && arr[x] > sub)
                        sub = arr[x];
                    if (arr[x] == max) {
                        if (prev != x - 1)
                            count++;
                        arr[x] = arr[x - 1];
                        prev = x;
                    }
                }
                max = sub;
            }
            dc.write(tokens[0] + " " + count + "\n");
        }

        dc.close();
        sc.close();
    }
}