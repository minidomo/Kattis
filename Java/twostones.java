
//  https://open.kattis.com/problems/twostones
import java.util.Scanner;

public class twostones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(n % 2 == 0 ? "Bob" : "Alice");
        sc.close();
    }
}