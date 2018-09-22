import java.io.*;
import java.util.*;

public class fenwick {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nums = sc.readLine().split(" ");
        int length = Integer.parseInt(nums[0]);
        int lines = Integer.parseInt(nums[1]);
        FenTree tree = new FenTree(length);
        while (lines-- > 0) {
            nums = sc.readLine().split(" ");
            if (nums[0].equals("+"))
                tree.update(Integer.parseInt(nums[1]), Integer.parseInt(nums[2]));
            else if (nums[0].equals("?"))
                dc.write(tree.range(Integer.parseInt(nums[1])) + "\n");
        }
        dc.close();
        sc.close();
    }

    private static class FenTree {
        private long[] arr;

        public FenTree(int length) {
            arr = new long[length + 1];
        }

        public void update(int index, int val) {
            for (index++; index < arr.length; index += index & -index)
                arr[index] += val;
        }

        public long range(int index) {
            long sum = 0;
            for (; index > 0; index -= index & -index)
                sum += arr[index];
            return sum;
        }
    }
}