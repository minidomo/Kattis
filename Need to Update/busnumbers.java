
// https://open.kattis.com/problems/busnumbers
import java.util.ArrayList;
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
        ArrayList<Integer> temp = new ArrayList<>();
        boolean first = true;
        for (int x = 0; x < cases; x++) {
            if (first) {
                temp.add(nums[x]);
                first = false;
            } else if (nums[x] == nums[x - 1] + 1) {
                temp.add(nums[x]);
            } else {
                if (temp.size() > 2)
                    System.out.print(temp.get(0) + "-" + temp.get(temp.size() - 1) + " ");
                else if (temp.size() == 2) {
                    System.out.print(temp.get(0) + " " + temp.get(1));
                } else {
                    System.out.print(temp.get(0) + " ");
                }
                first = true;
                temp.clear();
            }
        }
        sc.close();
    }
}
