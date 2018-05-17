
// https://open.kattis.com/problems/skocimis
import java.util.Scanner;

public class skocimis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int first = sc.nextInt();
        int mid = sc.nextInt();
        int last = sc.nextInt();
        
        int fdiff = mid - first - 1;
        int sdiff = last - mid - 1;
        
        System.out.println(fdiff > sdiff ? fdiff : sdiff);
        sc.close();
    }
}
