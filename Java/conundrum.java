
// https://open.kattis.com/problems/conundrum
import java.util.Scanner;

public class conundrum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String code = sc.nextLine();
        int days = 0;
        for (int s = 0; s < code.length(); s += 3) {
            if (code.charAt(s) != 'P')
                days++;
            if (code.charAt(s + 1) != 'E')
                days++;
            if (code.charAt(s + 2) != 'R')
                days++;
        }
        System.out.println(days);
        sc.close();
    }
}