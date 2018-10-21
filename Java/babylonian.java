import java.io.*;
import java.util.*;

public class babylonian {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        int cases = Integer.parseInt(sc.readLine());
        while (cases-- > 0) {
            String[] arr = (sc.readLine() + " ").split(",");
            long num = 0;
            for (int x = arr.length - 1; x >= 0; x--) {
                arr[x] = arr[x].trim();
                if (!arr[x].equals(""))
                    num += (long) Math.pow(60, arr.length - 1 - x) * Integer.parseInt(arr[x]);
            }
            dc.write(num + "\n");
        }

        dc.close();
        sc.close();
    }
}