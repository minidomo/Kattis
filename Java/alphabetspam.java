
// https://open.kattis.com/problems/alphabetspam
import java.util.Scanner;

public class alphabetspam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        double length = line.length();
        double whitespace = 0;
        double lowercase = 0;
        double uppercase = 0;
        double symbols = 0;
        for (int x = 0; x < line.length(); x++) {
            if (line.charAt(x) == '_')
                whitespace++;
            else if ((int) line.charAt(x) >= 97 && (int) line.charAt(x) <= 122)
                lowercase++;
            else if ((int) line.charAt(x) >= 65 && (int) line.charAt(x) <= 90)
                uppercase++;
            else
                symbols++;
        }
        System.out.printf("%.16f\n", whitespace / length);
        System.out.printf("%.16f\n", lowercase / length);
        System.out.printf("%.16f\n", uppercase / length);
        System.out.printf("%.16f\n", symbols / length);
        sc.close();
    }
}