
// https://open.kattis.com/problems/cd
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.HashSet;

public class cd {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        OutputStream dc = new BufferedOutputStream(System.out);

        while (true) {
            String line = sc.readLine();
            if (line.equals("0 0"))
                break;
            int space = line.indexOf(' ');
            int n = Integer.parseInt(line.substring(0, space));
            int m = Integer.parseInt(line.substring(space + 1));
            HashSet<String> cds = new HashSet<>(n);
            for (int x = 0; x < n; x++)
                cds.add(sc.readLine());
            for (int x = 0; x < m; x++)
                cds.add(sc.readLine());

            dc.write(((n + m) - cds.size() + "\n").getBytes());
        }
        sc.close();
        dc.flush();
    }
}