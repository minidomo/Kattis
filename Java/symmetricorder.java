
// https://open.kattis.com/problems/symmetricorder
import java.util.Scanner;

public class symmetricorder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int set = 1;
        while (true) {
            int cases = sc.nextInt();
            if (cases == 0)
                break;
            sc.nextLine();
            String[] names = new String[cases / 2];
            System.out.println("SET " + set);

            for (int x = names.length - 1; x >= 0; x--) {
                System.out.println(sc.nextLine());
                names[x] = sc.nextLine();
            }

            if (cases % 2 == 1)
                System.out.println(sc.nextLine());

            for (String s : names)
                System.out.println(s);

            set++;
        }
        sc.close();
    }
}