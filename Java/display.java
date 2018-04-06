
// https://open.kattis.com/problems/display
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class display {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String line = sc.readLine();
            if (line.equals("end"))
                break;
            char[][] time = new char[7][29];
            int i = 0;
            for (char[] r : time)
                Arrays.fill(r, ' ');
            for (char c : line.toCharArray()) {
                if (c == ':')
                    i += 3;
                else
                    i += 7;
                time = add(time, c, i);
            }
            for (char[] r : time) {
                for (char c : r)
                    dc.write(c);
                dc.write("\n");
            }
            dc.write("\n\n");
        }
        dc.write("end\n");
        sc.close();
        dc.flush();
    }

    private static char[][] add(char[][] arr, char w, int i) {
        i = i == 17 ? 14 : i - 7;
        int c = i;
        int r = 0;
        if (w == '0') {
            arr = hor(arr, r, c);
            for (int x = 0; x < 2; x++) {
                arr = lvert(arr, r, c);
                arr = rvert(arr, r, c);
                r += 3;
            }
            arr = hor(arr, r, c);
        } else if (w == '1') {
            for (int x = 0; x < 2; x++, r += 3)
                arr = rvert(arr, r, c);
        } else if (w == '2') {
            arr = hor(arr, r, c);
            arr = rvert(arr, r, c);
            r += 3;
            arr = hor(arr, r, c);
            arr = lvert(arr, r, c);
            r += 3;
            arr = hor(arr, r, c);
        } else if (w == '3') {
            for (int x = 0; x < 2; x++) {
                arr = hor(arr, r, c);
                arr = rvert(arr, r, c);
                r += 3;
            }
            arr = hor(arr, r, c);
        } else if (w == '4') {
            arr = lvert(arr, r, c);
            arr = rvert(arr, r, c);
            r += 3;
            arr = hor(arr, r, c);
            arr = rvert(arr, r, c);
        } else if (w == '5') {
            arr = hor(arr, r, c);
            arr = lvert(arr, r, c);
            r += 3;
            arr = hor(arr, r, c);
            arr = rvert(arr, r, c);
            r += 3;
            arr = hor(arr, r, c);
        } else if (w == '6') {
            arr = hor(arr, r, c);
            arr = lvert(arr, r, c);
            r += 3;
            arr = hor(arr, r, c);
            arr = lvert(arr, r, c);
            arr = rvert(arr, r, c);
            r += 3;
            arr = hor(arr, r, c);
        } else if (w == '7') {
            arr = hor(arr, r, c);
            for (int x = 0; x < 2; x++, r += 3)
                arr = rvert(arr, r, c);
        } else if (w == '8') {
            for (int x = 0; x < 2; x++) {
                arr = hor(arr, r, c);
                arr = lvert(arr, r, c);
                arr = rvert(arr, r, c);
                r += 3;
            }
            arr = hor(arr, r, c);
        } else if (w == '9') {
            arr = hor(arr, r, c);
            arr = lvert(arr, r, c);
            arr = rvert(arr, r, c);
            r += 3;
            arr = hor(arr, r, c);
            arr = rvert(arr, r, c);
            r += 3;
            arr = hor(arr, r, c);
        } else if (w == ':') {
            r = 2;
            for (int x = 0; x < 2; x++, r += 2)
                arr[r][c] = 'o';
        }
        return arr;
    }

    private static char[][] lvert(char[][] arr, int r, int c) {
        arr[r++][c] = '+';
        arr[r++][c] = '|';
        arr[r++][c] = '|';
        arr[r++][c] = '+';
        return arr;
    }

    private static char[][] rvert(char[][] arr, int r, int c) {
        c += 4;
        arr[r++][c] = '+';
        arr[r++][c] = '|';
        arr[r++][c] = '|';
        arr[r++][c] = '+';
        return arr;
    }

    private static char[][] hor(char[][] arr, int r, int c) {
        for (char a : "+---+".toCharArray())
            arr[r][c++] = a;
        return arr;
    }
}