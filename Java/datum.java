
// https://open.kattis.com/problems/datum
import java.util.HashMap;
import java.util.Scanner;

public class datum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<Integer, Integer> months = new HashMap<Integer, Integer>() {
            {
                put(1, 31);
                put(2, 28);
                put(3, 31);
                put(4, 30);
                put(5, 31);
                put(6, 30);
                put(7, 31);
                put(8, 31);
                put(9, 30);
                put(10, 31);
                put(11, 30);
                put(12, 31);
            }
        };
        HashMap<Integer, String> dayOfWeek = new HashMap<Integer, String>() {
            {
                put(0, "Wednesday");
                put(1, "Thursday");
                put(2, "Friday");
                put(3, "Saturday");
                put(4, "Sunday");
                put(5, "Monday");
                put(6, "Tuesday");
            }
        };

        int day = sc.nextInt();
        int month = sc.nextInt();
        if (month != 1)
            for (int x = 1; x < month; x++)
                day += months.get(x);
        System.out.println(dayOfWeek.get(day % 7));
        sc.close();
    }
}