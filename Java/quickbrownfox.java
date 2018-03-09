
// https://open.kattis.com/problems/quickbrownfox
import java.util.ArrayList;
import java.util.Scanner;

public class quickbrownfox {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();
        sc.nextLine();
        while (cases-- > 0) {
            String line = sc.nextLine().toLowerCase();
            char[] missing = noHave(line);
            if (missing.length == 0)
                System.out.println("pangram");
            else {
                String output = "";
                for (char s : missing)
                    output += s;
                System.out.println("missing " + output);
            }
        }

        sc.close();
    }

    private static char[] noHave(String a) {
        ArrayList<Character> temp = new ArrayList<>();
        for (char x = 'a'; x <= 'z'; x++)
            if (!a.contains("" + x))
                temp.add(x);

        char[] dontHave = new char[temp.size()];
        int d = 0;
        for (char s : temp)
            dontHave[d++] = s;

        return dontHave;
    }
}