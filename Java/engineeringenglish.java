
// https://open.kattis.com/problems/engineeringenglish
import java.util.HashSet;
import java.util.Scanner;

public class engineeringenglish {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashSet<String> words = new HashSet<>();
        while (sc.hasNextLine()) {
            for (String s : sc.nextLine().split(" "))
                if (words.contains(s.toLowerCase()))
                    System.out.print(". ");
                else {
                    System.out.print(s + " ");
                    words.add(s.toLowerCase());
                }
            System.out.println();
        }
        sc.close();
    }
}