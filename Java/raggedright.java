import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class raggedright {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Integer> lengths = new ArrayList<>();
        int max = 0;

        while (sc.ready()) {
            int len = sc.readLine().length();
            if (len > max)
                max = len;
            lengths.add(len);
        }

        int sum = 0;
        for (int x = 0; x < lengths.size() - 1; x++) {
            int amt = max - lengths.get(x);
            sum += (amt * amt);
        }

        dc.write(sum + "\n");

        dc.flush();
        dc.close();
        sc.close();
    }
}