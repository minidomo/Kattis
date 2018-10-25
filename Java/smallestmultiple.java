import java.util.*;
import java.io.*;
import java.math.*;

public class smallestmultiple {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        while ((line = sc.readLine()) != null) {
            String[] nums = line.split(" ");
            dc.write(lcm(nums) + "\n");
            dc.flush();
        }

        dc.close();
        sc.close();
    }

    private static BigInteger lcm(BigInteger a, BigInteger b) {
        return a.multiply(b).divide(a.gcd(b));
    }

    private static String lcm(String[] arr) {
        BigInteger res = new BigInteger(arr[0]);
        for (int x = 1; x < arr.length; x++)
            res = lcm(res, new BigInteger(arr[x]));
        return res.toString();
    }
}