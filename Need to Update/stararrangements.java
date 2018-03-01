
// https://open.kattis.com/problems/stararrangements
import java.util.ArrayList;
import java.util.Scanner;

public class stararrangements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();

        double stars = sc.nextInt();
        long start = System.currentTimeMillis();
        System.out.println((int) stars + ":");
        for (int a = 2; a < Math.round(stars / 2) + 1; a++) {
            int total = 0;
            int temp = a - 1;
            for (int s = 0; s < stars; s++) {
                total += s % 2 == 0 ? a : temp;
                if (total == stars) {
                    x.add(a);
                    y.add(temp);
                }
            }
            if (stars % a == 0) {
                x.add(a);
                y.add(a);
            }
        }
        for (int a = 0; a < x.size(); a++)
            System.out.println(x.get(a) + "," + y.get(a));

        long end = System.currentTimeMillis();
        System.out.println("\nTime: " + (double) (end - start) / 1000 + " seconds");

        sc.close();
    }
}
