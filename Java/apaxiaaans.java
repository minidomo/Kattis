
// https://open.kattis.com/problems/apaxiaaans
import java.util.Scanner;

public class apaxiaaans {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        String compact = "";
        if (name.length() == 1)
            compact = name;
        else {
            for (int x = 0; x < name.length() - 1; x++)
                if (name.charAt(x) != name.charAt(x + 1))
                    compact += name.charAt(x);
            compact += name.charAt(name.length() - 1);
        }
        System.out.println(compact);
        sc.close();
    }
}