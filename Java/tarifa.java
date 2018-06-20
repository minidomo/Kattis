
// https://open.kattis.com/problems/tarifa
import java.util.*;

public class tarifa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int amount = sc.nextInt();
        int lines = sc.nextInt();
        int nextMonth = amount;
        while (lines-- > 0) {
            int s = sc.nextInt();
            nextMonth += (amount - s);
        }
        System.out.println(nextMonth);
        sc.close();
    }
}