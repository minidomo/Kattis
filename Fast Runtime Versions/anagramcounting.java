
// Runtime: 0.10 s
// https://open.kattis.com/problems/anagramcounting
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;

public class anagramcounting {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        OutputStream dc = new BufferedOutputStream(System.out);

        while (sc.ready()) {
            char[] letters = sc.readLine().toCharArray();

            HashSet<Character> uniqueLetters = new HashSet<>();
            for (char s : letters)
                uniqueLetters.add(s);

            BigInteger length = factorial(BigInteger.valueOf(letters.length));

            for (char a : uniqueLetters) {
                BigInteger count = BigInteger.ZERO;
                for (char s : letters)
                    if (a == s)
                        count = count.add(BigInteger.ONE);
                length = length.divide(factorial(count));
            }
            dc.write((length + "\n").getBytes());
        }

        sc.close();
        dc.flush();
    }

    private static BigInteger factorial(BigInteger s) {
        if (s.equals(BigInteger.ZERO))
            return BigInteger.ONE;
        else
            return s.multiply(factorial(s.subtract(BigInteger.ONE)));
    }
}
