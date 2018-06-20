
// https://open.kattis.com/problems/anothercandies
import java.math.BigInteger;
import java.util.Scanner;

public class anothercandies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();
        while (cases-- > 0) {
            sc.nextLine();
            long children = sc.nextLong();
            BigInteger total = BigInteger.ZERO;
            for (long x = 0; x < children; x++)
                total = total.add(BigInteger.valueOf(sc.nextLong()));
            System.out.println(BigInteger.ZERO.equals(total.mod(BigInteger.valueOf(children))) ? "YES" : "NO");
        }

        sc.close();
    }
}