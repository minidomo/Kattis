
// https://open.kattis.com/problems/repeatingdecimal
import java.util.Scanner;

public class repeatingdecimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // long division
        while (sc.hasNextInt()) {
            int a = sc.nextInt() * 10;
            int b = sc.nextInt();
            int c = sc.nextInt();
            System.out.print("0.");
            while (c-- > 0) {
                System.out.print(a / b);
                a %= b;
                a *= 10;
            }
            System.out.println();
        }
        sc.close();
    }
}
