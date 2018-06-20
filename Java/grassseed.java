
// https://open.kattis.com/problems/grassseed
import java.util.Scanner;

public class grassseed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double cost = sc.nextDouble();
        int cases = sc.nextInt();
        double area = 0;
        while (cases-- > 0) {
            double width = sc.nextDouble();
            double length = sc.nextDouble();
            area += width * length;
        }
        System.out.printf("%.7f", area * cost);
        sc.close();
    }
}