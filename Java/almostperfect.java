
// https://open.kattis.com/problems/almostperfect
import java.util.Scanner;
import java.util.TreeSet;

public class almostperfect {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int num = sc.nextInt();
            int[] divisors = factors(num);
            int sum = 0;
            for (int s : divisors)
                sum += s;
            if (sum == num)
                System.out.println(num + " perfect");
            else if (sum >= num - 2 && sum <= num + 2)
                System.out.println(num + " almost perfect");
            else
                System.out.println(num + " not perfect");
        }
        sc.close();
    }

    private static int[] factors(int a) {
        if (isPrime(a))
            return new int[] { 1 };
        else {
            TreeSet<Integer> nums = new TreeSet<>();
            for (int x = 2; x <= Math.sqrt(a); x++)
                if (a % x == 0) {
                    nums.add(x);
                    nums.add(a / x);
                }
            nums.add(1);
            int[] arr = new int[nums.size()];
            int i = 0;
            for (int s : nums)
                arr[i++] = s;
            return arr;
        }
    }

    private static boolean isPrime(int a) {
        if (a < 2)
            return false;
        else if (a == 2 || a == 3)
            return true;
        else if (a % 2 == 0 || a % 3 == 0)
            return false;
        else {
            int sqrt = (int) Math.sqrt(a) + 1;
            for (int x = 6; x <= sqrt; x += 6)
                if (a % (x + 1) == 0 || a % (x - 1) == 0)
                    return false;
            return true;
        }
    }
}