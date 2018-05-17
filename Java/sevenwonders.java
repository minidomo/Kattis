
//  https://open.kattis.com/problems/sevenwonders
import java.util.Arrays;
import java.util.Scanner;

public class sevenwonders {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String letters = sc.nextLine();
        int[] counts = { 0, 0, 0 };
        for (int x = 0; x < letters.length(); x++) {
            if (letters.charAt(x) == 'T')
                counts[0]++;
            else if (letters.charAt(x) == 'C')
                counts[1]++;
            else
                counts[2]++;
        }
        Arrays.sort(counts);
        System.out.println(
                (int) (Math.pow(counts[0], 2) + Math.pow(counts[1], 2) + Math.pow(counts[2], 2) + (counts[0] * 7)));
        sc.close();
    }
}