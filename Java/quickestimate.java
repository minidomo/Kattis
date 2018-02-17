
// https://open.kattis.com/problems/quickestimate
import java.util.Scanner;

public class quickestimate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();
        sc.nextLine();
        while (cases-- > 0)
            System.out.println(sc.nextLine().length());
        sc.close();
    }
}