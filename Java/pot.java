
//  https://open.kattis.com/problems/pot
import java.util.Scanner;

public class pot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();
        int total = 0;
        sc.nextLine();

        while (cases-- > 0) {
            String line = sc.nextLine();
            int num = Integer.parseInt(line.substring(0, line.length() - 1));
            int power = Integer.parseInt(line.substring(line.length() - 1));
            total += Math.pow(num, power);
        }
        System.out.println(total);
        sc.close();
    }
}