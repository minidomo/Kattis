import java.io.*;
import java.util.*;

public class zoo {
    public static void main (String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String line;
        int i = 1;
        while (!(line = sc.readLine()).equals("0")) {
            TreeMap<String, Integer> map = new TreeMap<>();
            int cases = Integer.parseInt(line);
            while (cases-- > 0) {
                String[] tokens = sc.readLine().split(" ");
                String animal = tokens[tokens.length - 1].toLowerCase();
                map.put(animal, map.containsKey(animal) ? map.get(animal) + 1 : 1);
            }
            dc.write("List " + i++ + ":\n");
            for (Map.Entry<String, Integer> s : map.entrySet())
                dc.write(s.getKey() + " | " + s.getValue() + "\n");
            dc.flush();
        }
        
        dc.close();
        sc.close();
    }
}
