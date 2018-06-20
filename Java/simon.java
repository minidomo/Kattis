
// https://open.kattis.com/problems/simon
import java.util.Scanner;

public class simon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();
        sc.nextLine();
        while (cases-- > 0) {
            String line = sc.nextLine();
            System.out.println(line.contains("simon says") && line.length() > 11 ? line.substring(11) : "");
        }
        sc.close();
    }
}