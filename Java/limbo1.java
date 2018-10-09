import java.util.*;
import java.io.*;
import java.math.*;

public class limbo1 {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        BigInteger two = new BigInteger("2");

        int cases = Integer.parseInt(sc.readLine());
        while (cases-- > 0) {
            String[] nums = sc.readLine().split(" ");
            BigInteger left = new BigInteger(nums[0]);
            BigInteger right = new BigInteger(nums[1]);

            // gauss formulas
            // 1 + (left * (left + 1)) / 2
            // (right * (left + left + right + 3)) / 2

            BigInteger val1 = BigInteger.ONE.add(left.multiply(left.add(BigInteger.ONE)).divide(two));
            BigInteger val2 = right.multiply(left.add(left.add(right.add(BigInteger.ONE.add(two))))).divide(two);
            dc.write(val1.add(val2).toString() + "\n");
        }

        dc.close();
        sc.close();
    }
}