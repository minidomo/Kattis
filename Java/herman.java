
// https://open.kattis.com/problems/herman
import java.util.Scanner;

public class herman {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int radius = sc.nextInt();
        double area = Math.PI * Math.pow(radius, 2);
        double taxiArea = Math.pow(radius, 2) * 2;
        System.out.printf("%.6f\n", area);
        System.out.printf("%.6f", taxiArea);
        sc.close();
    }
}