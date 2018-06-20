
// https://open.kattis.com/problems/judgingmoose
import java.util.Scanner;

public class judgingmoose {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int left = sc.nextInt();
        int right = sc.nextInt();

        System.out.println(left == 0 && right == 0 ? "Not a moose"
                : left == right ? "Even " + (left + right) : left > right ? "Odd " + (left * 2) : "Odd " + (right * 2));
        sc.close();
    }
}