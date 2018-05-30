using System;

public class easiest {
    public static void Main (string[] args) {
        for (;;) {
            int n = int.Parse (Console.ReadLine ());
            if (n == 0)
                break;
            int sum = sumDigits (n);

            for (int x = 11;; x++)
                if (sum == sumDigits (x * n)) {
                    Console.WriteLine (x);
                    break;
                }
        }
    }
    private static int sumDigits (int a) {
        int sum = 0;
        while (a > 0) {
            sum += (a % 10);
            a /= 10;
        }
        return sum;
    }
}