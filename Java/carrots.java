
//  https://open.kattis.com/problems/carrots
import java.util.Scanner;

public class carrots {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int contestants = sc.nextInt();
        int solved = sc.nextInt();

        String name;
        while (contestants-- > 0)
            name = sc.nextLine();

        System.out.println(solved);
        sc.close();
    }
}