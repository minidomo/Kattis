import java.io.*;
import java.util.*;

public class unionfind {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nums = sc.readLine().split(" ");
        int length = Integer.parseInt(nums[0]);
        int lines = Integer.parseInt(nums[1]);
        int[] arr = new int[length];
        int[] count = new int[length];
        for (int x = 0; x < length; x++) {
            arr[x] = x;
            count[x] = 1;
        }
        while (lines-- > 0) {
            String[] line = sc.readLine().split(" ");
            int first = getRoot(arr, Integer.parseInt(line[1]));
            int second = getRoot(arr, Integer.parseInt(line[2]));
            if (line[0].equals("=")) {
                if (count[first] < count[second]) {
                    arr[first] = second;
                    count[second] += count[first];
                } else {
                    arr[second] = first;
                    count[first] += count[second];
                }
            } else if (line[0].equals("?"))
                dc.write(first == second ? "yes\n" : "no\n");
        }

        dc.close();
        sc.close();
    }

    private static int getRoot(int[] arr, int index) {
        while (arr[index] != index) {
            arr[index] = arr[arr[index]];
            index = arr[index];
        }
        return index;
    }
}