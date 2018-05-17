
// https://open.kattis.com/problems/railroad2
import java.util.Scanner;

public class railroad2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        sc.nextInt();
        System.out.println(sc.nextInt() % 2 == 0 ? "possible" : "impossible");

        sc.close();
    }
}
