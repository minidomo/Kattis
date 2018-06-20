
// https://open.kattis.com/problems/aaah
import java.util.Scanner;

public class aaah {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String say = sc.nextLine();
        String hear = sc.nextLine();
        System.out.println(say.compareTo(hear) > 0 ? "no" : "go");
        sc.close();
    }
}