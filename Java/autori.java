
//  https://open.kattis.com/problems/autori
import java.util.Scanner;

public class autori {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        String result = name.substring(0, 1);
        for (int x = 0; x < name.length(); x++)
            if (name.charAt(x) == '-')
                result += name.charAt(x + 1);
        System.out.println(result);
        sc.close();
    }
}