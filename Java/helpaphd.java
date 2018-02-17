
// https://open.kattis.com/problems/helpaphd
import java.util.Scanner;

public class helpaphd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();
        sc.nextLine();
        while (cases-- > 0) {
            String line = sc.nextLine();
            if (line.contains("P=NP"))
                System.out.println("skipped");
            else {
                int plus = line.indexOf("+");
                int fnum = Integer.parseInt(line.substring(0, plus));
                int snum = Integer.parseInt(line.substring(plus));
                System.out.println(fnum + snum);
            }
        }
        sc.close();
    }
}