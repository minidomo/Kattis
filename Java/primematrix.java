
// https://open.kattis.com/problems/primematrix
import java.util.ArrayList;
import java.util.Scanner;

public class primematrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int limit = sc.nextInt();

        if (size > limit)
            System.out.println("impossible");
        else {
            ArrayList<Integer> nums = new ArrayList<>(size);

            for (int x = 0; x < size; x++)
                nums.add(x + 1);

            int sum = 0;
            for (int s : nums)
                sum += s;

            int i = nums.size() - 1;
            checkPrime: 
            while (!isPrime(sum)) {
                while (nums.get(i) >= limit) {
                    i--;
                    limit--;
                    if (i == -1)
                        break checkPrime;
                }
                nums.add(i, nums.remove(i) + 1);
                sum = 0;
                for (int s : nums)
                    sum += s;
            }
            if (i == -1)
                System.out.println("impossible");
            else {

                for (int x = 0; x < size; x++) {
                    for (int s = 0; s < size; s++)
                        System.out.print(nums.get(s) + " ");
                    System.out.println();
                    nums.add(nums.remove(0));
                }
            }
        }
        sc.close();
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