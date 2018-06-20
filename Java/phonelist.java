
// https://open.kattis.com/problems/phonelist
import java.util.Arrays;
import java.util.Scanner;

public class phonelist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();
        while (cases-- > 0) {
            int phones = sc.nextInt();
            sc.nextLine();
            String[] nums = new String[phones];
            for (int x = 0; x < phones; x++)
                nums[x] = sc.nextLine();
            Arrays.sort(nums);
            boolean noPrefix = true;
            for (int x = 0; x < phones - 1; x++)
                if (nums[x + 1].startsWith(nums[x])) {
                    noPrefix = false;
                    break;
                }
            System.out.println(noPrefix ? "YES" : "NO");
        }
        sc.close();
    }
}