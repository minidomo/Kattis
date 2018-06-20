
//  https://open.kattis.com/problems/oddities
import java.util.Scanner;

public class oddities {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();
        while (cases-- > 0) {
            int num = sc.nextInt();
            System.out.println(num % 2 == 0 ? num + " is even" : num + " is odd");
        }
        sc.close();
    }
}