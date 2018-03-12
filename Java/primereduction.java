
// https://open.kattis.com/problems/primereduction
import java.util.ArrayList;
import java.util.Scanner;

public class primereduction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int num = sc.nextInt();
            if (num == 4)
                break;
            int count = 1;
            while (!isPrime(num)) {
                int[] primes = intoPrimes(num);
                num = 0;
                for (int s : primes)
                    num += s;
                count++;
            }
            System.out.println(num + " " + count);
        }
        sc.close();
    }

    private static int[] intoPrimes(int a) {
        ArrayList<Integer> nums = new ArrayList<>();
        if (isPrime(a))
            nums.add(a);
        else {
            int temp = a;
            while (!isPrime(temp)) {
                int[] arr = factors(temp);
                nums.add(arr[0]);
                temp = arr[1];
            }
            nums.add(temp);
        }
        int[] arr = new int[nums.size()];
        int i = 0;
        for (int s : nums)
            arr[i++] = s;
        return arr;
    }

    private static int[] factors(int a) {
        ArrayList<Integer> nums = new ArrayList<>();
        int half = a / 2;
        for (int x = 2; x <= half; x++)
            if (a % x == 0) {
                nums.add(x);
                nums.add(a / x);
                break;
            }
        int[] arr = new int[nums.size()];
        int i = 0;
        for (int s : nums)
            arr[i++] = s;
        return arr;
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