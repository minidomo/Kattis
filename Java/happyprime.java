
// https://open.kattis.com/problems/happyprime
import java.util.ArrayList;
import java.util.Scanner;

public class happyprime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();
        while (cases-- > 0) {
            int q = sc.nextInt();
            int num = sc.nextInt();
            System.out.println(isPrime(num) && isHappy(num) ? q + " " + num + " " + "YES" : q + " " + num + " " + "NO");
        }
        sc.close();
    }

    private static boolean isPrime(int a) {
        if (a < 2)
            return false;
        else if (a == 2 || a == 3)
            return true;
        else if (a % 2 == 0 || a % 3 == 0)
            return false;
        else {
            int sqrt = (int) Math.sqrt(a) + 1;
            for (int x = 6; x <= sqrt; x += 6)
                if (a % (x + 1) == 0 || a % (x - 1) == 0)
                    return false;
            return true;
        }
    }

    private static boolean isHappy(int a) {
        ArrayList<Integer> seen = new ArrayList<>();
        while (a > 1) {
            int sum = 0;
            for (char s : Integer.toString(a).toCharArray())
                sum += (int) Math.pow(Integer.parseInt(s + ""), 2);
            a = sum;
            if (seen.contains(a))
                break;
            seen.add(a);
        }
        return a == 1 ? true : false;
    }
}