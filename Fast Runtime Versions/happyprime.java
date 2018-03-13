
// Runtime: 0.14 s
// https://open.kattis.com/problems/happyprime
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;

public class happyprime {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        OutputStream dc = new BufferedOutputStream(System.out);

        int cases = Integer.parseInt(sc.readLine());
        while (cases-- > 0) {
            String s = sc.readLine();
            int a = s.indexOf(' ');
            int q = Integer.parseInt(s.substring(0, a));
            int num = Integer.parseInt(s.substring(a + 1));
            dc.write((isPrime(num) && isHappy(num) ? q + " " + num + " " + "YES\n" : q + " " + num + " " + "NO\n")
                    .getBytes());
        }
        sc.close();
        dc.flush();
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
