import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class backspace {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] arr = sc.readLine().toCharArray();
        for (int x = arr.length - 1, count = 0; x >= 0; x--) {
            if (arr[x] == '<') {
                arr[x] = ' ';
                count++;
            } else if (count > 0) {
                arr[x] = ' ';
                count--;
            }
        }
        dc.write(new String(arr).replaceAll(" ", ""));

        dc.flush();
        dc.close();
        sc.close();
    }
}