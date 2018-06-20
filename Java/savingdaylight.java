
// https://open.kattis.com/problems/savingdaylight
import java.util.Scanner;

public class savingdaylight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String month = sc.next();
            String day = sc.next();
            String year = sc.next();
            String current = sc.next();
            String start = sc.next();

            int i = current.indexOf(':');
            int chour = Integer.parseInt(current.substring(0, i));
            int cmin = Integer.parseInt(current.substring(i + 1));

            int u = start.indexOf(':');
            int shour = Integer.parseInt(start.substring(0, u));
            int smin = Integer.parseInt(start.substring(u + 1));

            int hour = 0;
            int min = 0;
            if (cmin <= smin) {
                min = smin - cmin;
                hour = shour - chour;
            } else {
                min = (60 - cmin) + smin;
                hour = shour - chour - 1;
            }
            System.out.println(month + " " + day + " " + year + " " + hour + " hours " + min + " minutes");
        }

        sc.close();
    }
}