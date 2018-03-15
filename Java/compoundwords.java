
// https://open.kattis.com/problems/compoundwords
import java.util.Scanner;
import java.util.TreeSet;

public class compoundwords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeSet<String> parts = new TreeSet<>();
        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split(" ");
            for (String s : line)
                parts.add(s);
        }
        TreeSet<String> words = new TreeSet<>();
        for (String s : parts) {
            for (String a : parts) {
                if (!s.equals(a))
                    words.add(s + a);
            }
        }
        for (String s : words)
            System.out.println(s);

        sc.close();
    }
}