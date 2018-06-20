
// https://open.kattis.com/problems/deathknight
import java.util.Scanner;

public class deathknight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int battles = sc.nextInt();
        int won = 0;
        sc.nextLine();
        while (battles-- > 0) {
            String abilities = sc.nextLine();
            if (!abilities.contains("CD"))
                won++;
        }
        System.out.println(won);
        sc.close();
    }
}