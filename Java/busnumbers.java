
// https://open.kattis.com/problems/busnumbers
import java.util.Arrays;
import java.util.Scanner;

public class busnumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();
        int[] nums = new int[cases];
        for (int x = 0; x < cases; x++)
            nums[x] = sc.nextInt();
        Arrays.sort(nums);
        int[] arr = new int[cases];
        int i = 0;
        arr[i++] = nums[0];
        for (int x = 1; x < cases; x++) {
            if (nums[x] == nums[x - 1] + 1)
                arr[i++] = nums[x];
            else {
                print(arr, i);
                i = 0;
                arr[i++] = nums[x];
            }
            if (x == cases - 1)
                print(arr, i);
        }
        sc.close();
    }

    private static void print(int[] arr, int i) {
        if (i > 2)
            System.out.print(arr[0] + "-" + arr[i - 1] + " ");
        else if (i == 2)
            System.out.print(arr[0] + " " + arr[1] + " ");
        else
            System.out.print(arr[0] + " ");
    }
}