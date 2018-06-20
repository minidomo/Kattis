
// https://open.kattis.com/problems/soylent
import java.util.Scanner;

public class soylent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();
        while (cases-- > 0) {
            int caloriesNeed = sc.nextInt();
            int calories = 0;
            int cups = 0;
            while (calories < caloriesNeed) {
                calories += 400;
                cups++;
            }
            System.out.println(cups);
        }
        sc.close();
    }
}