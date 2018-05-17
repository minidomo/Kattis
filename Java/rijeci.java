
// https://open.kattis.com/problems/rijeci
import java.util.Scanner;

public class rijeci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int pressed = sc.nextInt();
        int[] ab = fib(pressed);
        System.out.println(ab[0] + " " + ab[1]);

        sc.close();
    }

    private static int[] fib(int a) {
        int[] f = new int[a + 1];
        f[0] = 0;
        f[1] = 1;

        for (int x = 2; x <= a; x++)
            f[x] = f[x - 1] + f[x - 2];

        int[] s = { f[a - 1], f[a] };
        return s;
    }
}