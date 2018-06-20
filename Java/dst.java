
// https://open.kattis.com/problems/dst
import java.util.Scanner;

public class dst {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();
        while (cases-- > 0) {
            String roll = sc.next();
            int change = sc.nextInt();
            int hours = sc.nextInt();
            int mins = sc.nextInt();

            int count = 0;
            if (roll.equals("F")) {
                mins += change;
                while (mins >= 60) {
                    mins -= 60;
                    count++;
                }
                hours += count;
                hours %= 24;
            } else {
                mins -= change;
                while (mins < 0) {
                    mins += 60;
                    count++;
                }
                hours -= count;
                if (hours < 0)
                    hours += 24;
            }
            System.out.println(hours + " " + mins);
        }

        sc.close();
    }
}
