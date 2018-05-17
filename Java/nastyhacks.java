
// https://open.kattis.com/problems/nastyhacks
import java.util.Scanner;

public class nastyhacks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();
        while (cases-- > 0) {
            int noAdvertise = sc.nextInt();
            int ifAdvertise = sc.nextInt();
            int cost = sc.nextInt();
            System.out.println(noAdvertise == ifAdvertise - cost ? "does not matter"
                    : noAdvertise > ifAdvertise - cost ? "do not advertise" : "advertise");
        }
        sc.close();
    }
}