
// https://open.kattis.com/problems/automatictrading
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class automatictrading {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] arr = sc.readLine().toCharArray();
        HashMap<String, Integer> dict = new HashMap<>();
        int cases = Integer.parseInt(sc.readLine());
        while (cases-- > 0) {
            String z = sc.readLine();
            if (dict.containsKey(z)) {
                dc.write(dict.get(z) + "\n");
                continue;
            }
            String[] line = z.split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            int count = 0;
            for (; b < arr.length && arr[a] == arr[b]; a++, b++)
                count++;
            dict.put(z, count);
            dc.write(count + "\n");
        }

        dc.flush();
        sc.close();
        dc.close();
    }
}