import java.io.*;
import java.util.*;

public class okviri {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[][] arr = new char[5][5 * s.length() - s.length() + 1];
        for (char[] r : arr)
            Arrays.fill(r, '.');
        int letter = 1;
        for (int x = 0; x < arr[0].length; x += 4) {
            char a = '#';
            if (letter % 3 == 0)
                a = '*';
            boolean star = arr[2][x] == '*';
            arr[0][x + 2] = arr[4][x + 2] = arr[1][x
                    + 1] = arr[1][x + 3] = arr[3][x + 1] = arr[3][x + 3] = arr[2][x] = arr[2][x + 4] = a;
            if (star)
                arr[2][x] = '*';
            arr[2][x + 2] = s.charAt(letter - 1);
            if (letter++ == s.length())
                break;
        }
        StringBuilder res = new StringBuilder();
        for (char[] r : arr) {
            for (char c : r)
                res.append(c);
            res.append('\n');
        }
        System.out.print(res);
    }
}