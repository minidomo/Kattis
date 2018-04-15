
// https://open.kattis.com/problems/boatparts
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeSet;

public class boatparts {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = sc.readLine().split(" ");
        int totalparts = Integer.parseInt(line[0]);
        int days = Integer.parseInt(line[1]);
        boolean found = false;
        TreeSet<String> parts = new TreeSet<>();
        for (int x = 1; x <= days; x++) {
            if (parts.size() != totalparts)
                parts.add(sc.readLine());
            if (parts.size() == totalparts) {
                dc.write(x + "\n");
                found = true;
                break;
            }
        }
        if (!found)
            dc.write("paradox avoided\n");
        dc.flush();
        sc.close();
        dc.close();
    }
}