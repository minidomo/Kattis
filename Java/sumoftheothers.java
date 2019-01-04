import java.io.*;
import java.util.*;

public class sumoftheothers {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        String line;
        while ((line = sc.readLine()) != null) {
            String[] arr = line.split(" ");
            int[] nums = new int[arr.length];
            int total = 0;
            for (int x = 0; x < arr.length; x++) {
                nums[x] = Integer.parseInt(arr[x]);
                total += nums[x];
            }
            for (int x = 0; x < arr.length; x++) {
                int num = nums[x];
                if (num == total - num) {
                    dc.write(num + "\n");
                    break;
                }
            }
        }
        dc.close();
        sc.close();
    }
}