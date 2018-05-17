
// https://open.kattis.com/problems/reverserot
import java.util.Scanner;

public class reverserot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ_.";

        while (true) {
            int rot = sc.nextInt();
            if (rot == 0)
                break;
            char[] arr = sc.nextLine().substring(1).toCharArray();
            String decode = "";
            for (int a = arr.length - 1; a >= 0; a--) {
                int index = 0;
                for (int x = 0; x < alpha.length(); x++)
                    if (alpha.charAt(x) == arr[a]) {
                        index = x + rot;
                        break;
                    }
                index %= alpha.length();
                decode += alpha.charAt(index);
            }
            System.out.println(decode);
        }
        sc.close();
    }
}