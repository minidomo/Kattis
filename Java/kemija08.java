
// https://open.kattis.com/problems/kemija08
import java.util.Scanner;

public class kemija08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
        String sentence = sc.nextLine();
        String decode = "";
        for (int x = 0; x < sentence.length(); x++) {
            for (int z = 0; z < vowels.length; z++) {
                if (sentence.charAt(x) == vowels[z])
                    x += 2;
            }
            decode += sentence.charAt(x);
        }
        System.out.println(decode);
        sc.close();
    }
}