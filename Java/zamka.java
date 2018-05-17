
// https://open.kattis.com/problems/zamka
import java.util.Scanner;

public class zamka {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int l = sc.nextInt();
        int d = sc.nextInt();
        int x = sc.nextInt();
        for (int a = l; a <= d; a++) {
            String num = Integer.toString(a);
            char[] temp = num.toCharArray();
            int total = 0;
            for (char q : temp)
                total += Integer.parseInt(Character.toString(q));
            if (total == x) {
                System.out.println(a);
                break;
            }
        }

        for (int a = d; a >= l; a--) {
            String num = Integer.toString(a);
            char[] temp = num.toCharArray();
            int total = 0;
            for (char q : temp)
                total += Integer.parseInt(Character.toString(q));
            if (total == x) {
                System.out.println(a);
                break;
            }
        }
        sc.close();
    }
}