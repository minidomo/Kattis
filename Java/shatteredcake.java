
// https://open.kattis.com/problems/shatteredcake
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class shatteredcake {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int width = Integer.parseInt(sc.readLine());
        int pieces = Integer.parseInt(sc.readLine());
        int area = 0;
        while (pieces-- > 0) {
            String w = sc.readLine();
            int s = w.indexOf(' ');
            area += Integer.parseInt(w.substring(0, s)) * Integer.parseInt(w.substring(s + 1));
        }
        System.out.println(area / width);

        sc.close();
    }
}