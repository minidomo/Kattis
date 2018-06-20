
// https://open.kattis.com/problems/ladder
import java.util.Scanner;

public class ladder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opposite = sc.nextInt();
        int angle = sc.nextInt();

        double adjacent = opposite / Math.tan(Math.toRadians(angle));
        double hypot = Math.sqrt(Math.pow(opposite, 2) + Math.pow(adjacent, 2));
        System.out.println((int) Math.ceil(hypot));
        sc.close();
    }
}