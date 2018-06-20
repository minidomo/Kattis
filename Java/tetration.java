
// https://open.kattis.com/problems/tetration
import java.util.Scanner;

public class tetration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double a = sc.nextDouble();
        System.out.printf("%.6f", Math.pow(a, 1 / a));

        sc.close();
    }
}