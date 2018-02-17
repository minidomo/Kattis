
// https://open.kattis.com/problems/detaileddifferences
import java.util.Scanner;

public class detaileddifferences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();
        while (cases-- > 0) {
            String pair1 = sc.next();
            String pair2 = sc.next();
            System.out.println(pair1 + "\n" + pair2);
            for (int x = 0; x < pair1.length(); x++) {
                if (pair1.charAt(x) == pair2.charAt(x))
                    System.out.print(".");
                else
                    System.out.print("*");
            }
            System.out.println("\n");
        }
        sc.close();
    }
}