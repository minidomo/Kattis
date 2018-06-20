
// https://open.kattis.com/problems/oddmanout
import java.util.Scanner;

public class oddmanout {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();
        for (int a = 1; a <= cases; a++) {
            int guestsNum = sc.nextInt();
            int[] guests = new int[guestsNum];
            for (int x = 0; x < guests.length; x++)
                guests[x] = sc.nextInt();
            for (int x : guests) {
                int count = 0;
                for (int z : guests)
                    if (z == x)
                        count++;
                if (count == 1)
                    System.out.println("Case #" + a + ": " + x);
            }
        }
        sc.close();
    }
}