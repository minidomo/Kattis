
//  https://open.kattis.com/problems/cold
import java.util.Scanner;

public class cold {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();
        int count = 0;
        while (cases-- > 0)
            if (sc.nextInt() < 0)
                count++;
        System.out.println(count);
        sc.close();
    }
}