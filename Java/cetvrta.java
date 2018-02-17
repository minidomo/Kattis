
// https://open.kattis.com/problems/cetvrta
import java.util.Scanner;

public class cetvrta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] x = new int[3];
        int[] y = new int[3];
        for (int z = 0; z < 3; z++) {
            x[z] = sc.nextInt();
            y[z] = sc.nextInt();
        }

        for (int s : x) {
            int count = 0;
            for (int a : x)
                if (s == a)
                    count++;
            if (count == 1)
                System.out.print(s + " ");
        }

        for (int s : y) {
            int count = 0;
            for (int a : y)
                if (s == a)
                    count++;
            if (count == 1)
                System.out.print(s);
        }
        sc.close();
    }
}
