
// https://open.kattis.com/problems/ostgotska
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ostgotska {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        String[] words = sc.readLine().split(" ");
        double count = 0;
        for (String s : words)
            if (s.contains("ae"))
                count++;
        System.out.println(count / words.length >= .4 ? "dae ae ju traeligt va" : "haer talar vi rikssvenska");
        sc.close();
    }
}
