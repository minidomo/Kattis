
// https://open.kattis.com/problems/simonsays
import java.util.Scanner;

public class simonsays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();
        sc.nextLine();
        while (cases-- > 0) {
            String command = sc.nextLine();
            if (command.contains("Simon says"))
                System.out.println(command.substring(11));
        }
        sc.close();
    }
}