
// https://open.kattis.com/problems/tolower
import java.util.Scanner;

public class tolower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int problems = sc.nextInt();
        int cases = sc.nextInt();
        int max = problems;
        sc.nextLine();
        for (int x = 0; x < problems; x++) {
            boolean moreUpper = false;
            for (int a = 0; a < cases; a++) {
                String line = sc.nextLine();
                if (!moreUpper) {
                    char[] chars = line.toCharArray();
                    for (int s = 1; s < chars.length; s++) {
                        if (Character.isUpperCase(chars[s])) {
                            moreUpper = true;
                            break;
                        }
                    }
                }
            }
            if (moreUpper)
                max--;
        }
        System.out.println(max);
        sc.close();
    }
}