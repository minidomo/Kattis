
// https://open.kattis.com/problems/touchscreenkeyboard
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class touchscreenkeyboard {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        char[][] keyboard = { { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' },
                { 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l' }, { 'z', 'x', 'c', 'v', 'b', 'n', 'm' } };

        int cases = Integer.parseInt(sc.readLine());
        while (cases-- > 0) {
            String[] line = sc.readLine().split(" ");
            int length = Integer.parseInt(line[1]);
            String[] words = new String[length];
            for (int x = 0; x < length; x++) {
                String word = sc.readLine();
                int dist = 0, i = 0;
                for (char c : word.toCharArray())
                    dist += distance(keyboard, line[0].charAt(i++), c);
                words[x] = word + " " + dist;
            }
            Arrays.sort(words, (a, b) -> {
                int z = Integer.parseInt(a.split(" ")[1]);
                int x = Integer.parseInt(b.split(" ")[1]);
                return z == x ? a.compareTo(b) : z - x;
            });
            for (String s : words)
                dc.write(s + "\n");
        }
        dc.flush();
        sc.close();
        dc.close();
    }

    private static int distance(char[][] arr, char a, char b) {
        int[] ax = findCoords(arr, a);
        int[] bx = findCoords(arr, b);
        return Math.abs(ax[0] - bx[0]) + Math.abs(ax[1] - bx[1]);
    }

    private static int[] findCoords(char[][] arr, char a) {
        for (int r = 0; r < arr.length; r++)
            for (int c = 0; c < arr[r].length; c++)
                if (arr[r][c] == a)
                    return new int[] { r, c };
        return new int[] { -1, -1 };
    }
}
