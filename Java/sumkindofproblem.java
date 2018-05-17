
// https://open.kattis.com/problems/sumkindofproblem
import java.util.Scanner;

public class sumkindofproblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();
        while (cases-- > 0) {
            int caseNum = sc.nextInt();
            System.out.print(caseNum + " ");
            int num = sc.nextInt();
            int sum = 0;
            for (int x = 1; x <= num; x++)
                sum += x;
            System.out.print(sum + " " + ((sum * 2) - num) + " " + (sum * 2) + "\n");
        }
        sc.close();
    }
}
