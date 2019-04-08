import java.io.*;
import java.math.*;
import java.util.*;

public class checkingforcorrectness {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder out = new StringBuilder();
        BigInteger MOD = BigInteger.valueOf(10000);
        while (sc.hasNext()) {
            BigInteger a = sc.nextBigInteger();
            char op = sc.next().charAt(0);
            BigInteger b = sc.nextBigInteger();
            BigInteger res;
            if (op == '+')
                res = a.add(b).mod(MOD);
            else if (op == '*')
                res = a.multiply(b).mod(MOD);
            else
                res = a.modPow(b, MOD);
            out.append(res).append('\n');
        }
        System.out.println(out);
        sc.close();
    }
}