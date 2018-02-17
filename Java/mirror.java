
// https://open.kattis.com/problems/mirror
import java.util.Scanner;

public class mirror {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();
        for (int x = 1; x <= cases; x++) {
            int rows = sc.nextInt();
            sc.nextLine();
            String[] order = new String[rows];
            int index = 0;
            while (rows-- > 0) {
                String pattern = new StringBuffer(sc.nextLine()).reverse().toString();
                order[index] = pattern;
                index++;
            }
            System.out.println("Test " + x);
            for (int a = order.length - 1; a >= 0; a--)
                System.out.println(order[a]);
        }
        sc.close();
    }
}