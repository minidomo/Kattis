import java.io.*;
import java.util.*;

public class variablearithmetic {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        HashMap<String, Integer> map = new HashMap<>();
        String line;
        while ((line = sc.readLine()) != null) {
            if (line.equals("0"))
                break;
            if (!line.contains(" = ")) {
                String[] arr = line.split(" \\+ ");
                int sum = 0;
                String other = "";
                for (int x = 0; x < arr.length; x++) {
                    if (map.containsKey(arr[x]))
                        sum += map.get(arr[x]);
                    else if (arr[x].matches("^\\d+$"))
                        sum += Integer.parseInt(arr[x]);
                    else
                        other += arr[x] + " + ";
                }
                if (other.length() > 0) {
                    other = other.substring(0, other.length() - 3);
                    if (sum != 0)
                        other = sum + " + " + other;
                    dc.write(other + "\n");
                } else
                    dc.write(sum + "\n");
            } else {
                String[] arr = line.split(" = ");
                map.put(arr[0], Integer.parseInt(arr[1]));
            }
        }
        dc.close();
        sc.close();
    }
}