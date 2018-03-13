
// Runtime: 0.07 s
// https://open.kattis.com/problems/primematrix
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;

public class primematrix {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        OutputStream dc = new BufferedOutputStream(System.out);

        String q = sc.readLine();
        int space = q.indexOf(' ');
        int size = Integer.parseInt(q.substring(0, space));
        int limit = Integer.parseInt(q.substring(space + 1));

        if (size > limit)
            dc.write(("impossible").getBytes());
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
                dc.write(("impossible").getBytes());
            else {

                for (int x = 0; x < size; x++) {
                    for (int s = 0; s < size; s++)
                        dc.write((nums.get(s) + " ").getBytes());
                    dc.write(("\n").getBytes());
                    nums.add(nums.remove(0));
                }
            }
        }
        sc.close();
        dc.flush();
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
