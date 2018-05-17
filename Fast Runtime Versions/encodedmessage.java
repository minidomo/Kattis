
// Runtime: 0.27 s
// https://open.kattis.com/problems/encodedmessage
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class encodedmessage {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        OutputStream dc = new BufferedOutputStream(System.out);

        int cases = Integer.parseInt(sc.readLine());
        while (cases-- > 0) {
            char[] encoded = sc.readLine().toCharArray();
            int side = (int) Math.sqrt(encoded.length);
            char[][] letters = new char[side][side];
            int i = 0;
            for (int row = 0; row < side; row++)
                for (int col = 0; col < side; col++)
                    letters[row][col] = encoded[i++];

            for (int col = side - 1; col >= 0; col--)
                for (int row = 0; row < side; row++)
                    dc.write((letters[row][col] + "").getBytes());
            dc.write(("\n").getBytes());
        }
        sc.close();
        dc.flush();
    }
}
