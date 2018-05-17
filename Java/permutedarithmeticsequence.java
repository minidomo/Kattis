
// https://open.kattis.com/problems/permutedarithmeticsequence
import java.util.Arrays;
import java.util.Scanner;

public class permutedarithmeticsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();

        while (cases-- > 0) {
            int length = sc.nextInt();
            int[] num = new int[length];

            for (int x = 0; x < length; x++)
                num[x] = sc.nextInt();

            int diff = num[0] - num[1];
            boolean passed = false;

            for (int x = 1; x < length - 1; x++) {
                if (num[x] - num[x + 1] != diff)
                    break;
                else
                    passed = true;
            }

            if (!passed) {
                Arrays.sort(num);
                diff = num[0] - num[1];
                for (int x = 1; x < length - 1; x++) {
                    if (num[x] - num[x + 1] != diff)
                        break;
                    else
                        passed = true;
                }
                System.out.println(passed ? "permuted arithmetic" : "non-arithmetic");
            } else {
                System.out.println("arithmetic");
            }

        }

        sc.close();
    }
}
