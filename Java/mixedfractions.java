
// https://open.kattis.com/problems/mixedfractions
import java.util.Scanner;

public class mixedfractions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            double n = sc.nextDouble();
            double d = sc.nextDouble();
            if (n == 0 && d == 0)
                break;
            System.out.println(
                    d > n ? "0 " + (int) n + " / " + (int) d : (int) (n / d) + " " + (int) (n % d) + " / " + (int) d);
        }

        sc.close();
    }
}