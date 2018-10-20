import java.io.*;
import java.util.*;

public class fridge {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[10];
        for (char c : sc.readLine().toCharArray()) {
            int num = c - '0';
            arr[num]++;
        }

        int minKey = 0, minVal = Integer.MAX_VALUE;
        boolean done = false;
        for (int x = 1; x < arr.length; x++) {
            if (arr[x] == 0) {
                dc.write(x + "\n");
                done = true;
                break;
            }
            if (arr[x] < minVal) {
                minKey = x;
                minVal = arr[x];
            }
        }

        if (!done) {
            if (arr[0] == 0)
                dc.write("10\n");
            else {
                dc.write(minKey + "");
                arr[minKey]--;
                if (arr[0] <= arr[minKey])
                    minKey = 0;
                while (arr[minKey]-- >= 0)
                    dc.write(minKey + "");
            }
        }

        dc.close();
        sc.close();
    }
}