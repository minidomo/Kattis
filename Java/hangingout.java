
// https://open.kattis.com/problems/hangingout
import java.util.Scanner;

public class hangingout {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int limit = sc.nextInt();
        int events = sc.nextInt();
        int terace = 0;
        int cantGo = 0;
        while (events-- > 0) {
            String status = sc.next();
            int people = sc.nextInt();
            if (status.equals("enter") && terace + people <= limit)
                terace += people;
            else if (status.equals("leave"))
                terace -= people;
            else
                cantGo++;
        }
        System.out.println(cantGo);
        sc.close();
    }
}