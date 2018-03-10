
// https://open.kattis.com/problems/anagramcountings
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class anagramcounting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String word = sc.nextLine();
            ArrayList<Character> letters = new ArrayList<>();
            for (int x = 0; x < word.length(); x++)
                letters.add(word.charAt(x));

            HashSet<Character> uniqueLetters = new HashSet<>(letters);

            BigInteger length = factorial(BigInteger.valueOf(word.length()));

            for (char a : uniqueLetters) {
                BigInteger count = BigInteger.ZERO;
                for (char s : letters)
                    if (a == s)
                        count = count.add(BigInteger.ONE);
                length = length.divide(factorial(count));
            }
            System.out.println(length);
        }

        sc.close();
    }

    private static BigInteger factorial(BigInteger s) {
        if (s.equals(BigInteger.ZERO))
            return BigInteger.ONE;
        else
            return s.multiply(factorial(s.subtract(BigInteger.ONE)));
    }
}