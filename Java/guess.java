
// https://open.kattis.com/problems/guess
import java.util.Scanner;

public class guess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int min = 1;
        int max = 1000;
        while (true) {
            int guess = (min + max) / 2;
            System.out.println(guess);
            String reply = sc.nextLine();
            if (reply.equals("correct"))
                break;
            else if (reply.equals("lower"))
                max = guess - 1;
            else if (reply.equals("higher"))
                min = guess + 1;
        }
        sc.close();
    }
}