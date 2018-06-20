
// https://open.kattis.com/problems/justaminute
import java.util.Scanner;

public class justaminute {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();
        int min = 0;
        int sec = 0;
        while (cases-- > 0) {
            min += sc.nextInt() * 60;
            sec += sc.nextInt();
        }
        if (min >= sec)
            System.out.println("measurement error");
        else
            System.out.printf("%.9f", (double) sec / min);
        sc.close();
    }
}