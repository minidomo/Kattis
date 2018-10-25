
// https://open.kattis.com/problems/sortofsorting
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class sortofsorting {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        for (;;) {
            String line = sc.readLine();
            if (line.equals("0"))
                break;
            TreeMap<String, ArrayList<String>> map = new TreeMap<>();
            int cases = Integer.parseInt(line);
            while (cases-- > 0) {
                String name = sc.readLine();
                String two = name.substring(0, 2);
                if (!map.containsKey(two))
                    map.put(two, new ArrayList<>(Arrays.asList(name)));
                else
                    map.get(two).add(name);
            }
            for (Map.Entry<String, ArrayList<String>> m : map.entrySet()) {
                for (String s : m.getValue())
                    dc.write(s + "\n");
            }
            dc.write("\n");
        }
        dc.close();
        sc.close();
    }
}