
// https://open.kattis.com/problems/kornislav
import java.util.Arrays;
import java.util.Scanner;

public class kornislav {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nums = new int[4];
        for (int x = 0; x < nums.length; x++)
            nums[x] = sc.nextInt();
        Arrays.sort(nums);
        System.out.println(nums[0] * nums[2]);
        sc.close();
    }
}