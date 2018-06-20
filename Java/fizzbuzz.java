
// https://open.kattis.com/problems/fizzbuzz
import java.util.Scanner;

public class fizzbuzz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int n = sc.nextInt() + 1;

        for (int d = 1; d < n; d++)
            System.out.println(d % x == 0 && d % y == 0 ? "FizzBuzz"
                    : d % x == 0 && d % y != 0 ? "Fizz" : d % x != 0 && d % y == 0 ? "Buzz" : Integer.toString(d));
        sc.close();
    }
}