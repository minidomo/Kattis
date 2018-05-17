
// https://open.kattis.com/problems/pizza2
import java.util.Scanner;

public class pizza2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int radius = sc.nextInt();
        int cheese = radius - sc.nextInt();

        double area = Math.pow(radius, 2) * Math.PI;
        double cheeseArea = Math.pow(cheese, 2) * Math.PI;
        double percent = (cheeseArea / area) * 100;
        System.out.printf("%.6f", percent);
    }
}
