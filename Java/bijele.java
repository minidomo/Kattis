
//  https://open.kattis.com/problems/bijele
import java.util.Scanner;

public class bijele {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int correct[] = { 1, 1, 2, 2, 2, 8 };

        for (int x : correct)
            System.out.print(x - sc.nextInt() + " ");
        sc.close();
    }
}