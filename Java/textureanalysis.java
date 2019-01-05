import java.io.*;
import java.util.*;

public class textureanalysis {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        HashMap<String, String> map = new HashMap<>();
        int i = 1;
        for (;;) {
            String line = sc.readLine();
            if (line.equals("END"))
                break;
            if (map.containsKey(line)) {
                dc.write(i++ + " " + map.get(line) + "\n");
            } else if (!line.contains(".")) {
                map.put(line, " EVEN");
                dc.write(i++ + " EVEN\n");
            } else {
                int black = line.length() - line.replace("*", "").length();
                int white = line.indexOf('.');
                white = line.substring(white, line.indexOf('*', white)).length();
                String reg = "(\\*";
                for (int x = 0; x < white; x++)
                    reg += "\\.";
                String s = reg + "){" + (black - 1) + "}\\*";
                String ans = line.matches(s) ? "EVEN" : "NOT EVEN";
                map.put(line, ans);
                dc.write(i++ + " " + ans + "\n");
            }
        }
        dc.close();
        sc.close();
    }
}