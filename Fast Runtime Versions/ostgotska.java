
// Runtime: 0.05 s
// https://open.kattis.com/problems/ostgotska
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class ostgotska {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        OutputStream dc = new BufferedOutputStream(System.out);

        String[] words = sc.readLine().split(" ");
        double count = 0;
        for (String s : words)
            if (s.contains("ae"))
                count++;
        dc.write((count / words.length >= .4 ? "dae ae ju traeligt va\n" : "haer talar vi rikssvenska\n").getBytes());
        sc.close();
        dc.flush();
    }
}
