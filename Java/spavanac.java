
//  https://open.kattis.com/problems/spavanac
import java.util.Scanner;

public class spavanac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int hour = sc.nextInt();
        int min = sc.nextInt() - 45;
        if (min < 0) {
            min += 60;
            hour--;
            if (hour < 0)
                hour = 23;
        }
        System.out.println(hour + " " + min);
        sc.close();
    }
}