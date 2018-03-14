
// https://open.kattis.com/problems/differentdistances
import java.util.Scanner;

public class differentdistances {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String temp = sc.nextLine();
            if (temp.equals("0"))
                break;
            String[] nums = temp.split(" ");
            double p = Double.parseDouble(nums[4]);
            double x = Math.pow(Math.abs(Double.parseDouble(nums[0]) - Double.parseDouble(nums[2])), p);
            double y = Math.pow(Math.abs(Double.parseDouble(nums[1]) - Double.parseDouble(nums[3])), p);
            System.out.printf("%.10f\n", Math.pow(x + y, 1 / p));
        }
        sc.close();
    }
}