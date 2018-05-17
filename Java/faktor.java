
//  https://open.kattis.com/problems/faktor
import java.util.Scanner;

public class faktor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int articles = sc.nextInt();
        int impact = sc.nextInt() - 1;
        System.out.println(articles * impact + 1);
        sc.close();
    }
}