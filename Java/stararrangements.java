
// https://open.kattis.com/problems/stararrangements
import java.util.Scanner;

public class stararrangements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double stars = sc.nextDouble();
        System.out.println((int) stars + ":");
        for (int x = 2; x < Math.round(stars / 2) + 1; x++) {
            int y = x - 1;
            if (stars % (x + y) == x || stars % (x + y) == 0)
                System.out.println(x + "," + y);
            if (stars % x == 0)
                System.out.println(x + "," + x);
        }
        sc.close();
    }
}