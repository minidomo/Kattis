
// https://open.kattis.com/problems/everywhere
import java.util.HashSet;
import java.util.Scanner;

public class everywhere {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();
        while (cases-- > 0) {
            HashSet<String> cities = new HashSet<>();
            int trips = sc.nextInt();
            while (trips-- > 0)
                cities.add(sc.next());
            System.out.println(cities.size());
        }
        sc.close();
    }
}