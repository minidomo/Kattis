import java.io.*;
import java.util.*;

public class babelfish {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<String, String> dict = new HashMap<>();
        String line;
        while ((line = sc.readLine()).contains(" ")) {
            String[] arr = line.split(" ");
            dict.put(arr[1], arr[0]);
        }

        while ((line = sc.readLine()) != null)
            dc.write(dict.containsKey(line) ? dict.get(line) + "\n" : "eh\n");

        dc.close();
        sc.close();
    }
}