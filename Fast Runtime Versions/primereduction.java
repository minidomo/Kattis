
// Runtime: 0.40 s
// https://open.kattis.com/problems/primereduction
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;

public class primereduction {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        OutputStream dc = new BufferedOutputStream(System.out);

        while (true) {
            int num = Integer.parseInt(sc.readLine());
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
            dc.write((num + " " + count + "\n").getBytes());
        }
        sc.close();
        dc.flush();
    }

    private static int[] intoPrimes(int a) {
        ArrayList<Integer> nums = new ArrayList<>();
        while (!isPrime(a)) {
            int[] arr = factors(a);
            nums.add(arr[0]);
            a = arr[1];
        }
        nums.add(a);
        int[] arr = new int[nums.size()];
        int i = 0;
        for (int s : nums)
            arr[i++] = s;
        return arr;
    }

    private static int[] factors(int a) {
        int[] arr = new int[2];
        int half = a / 2;
        for (int x = 2; x <= half; x++)
            if (a % x == 0) {
                arr[0] = x;
                arr[1] = a / x;
                break;
            }
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
