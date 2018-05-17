
//  https://open.kattis.com/problems/r2
import java.util.Scanner;

public class r2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int fnum = sc.nextInt();
        int mean = sc.nextInt();
        System.out.println((mean * 2) - fnum);
        sc.close();
    }
}