import java.io.*;
import java.util.*;

public class combinationlock {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        while (!(line = sc.readLine()).equals("0 0 0 0")) {
            String[] arr = line.split(" ");
            int start = Integer.parseInt(arr[0]);
            int a = Integer.parseInt(arr[1]), b = Integer.parseInt(arr[2]), c = Integer.parseInt(arr[3]);
            int degrees = 1080;
            final int dpt = 9;
            if (a > start)
                start += 40;
            degrees += (start - a) * dpt;
            if (a > b)
                a -= 40;
            degrees += (b - a) * dpt;
            if (c > b)
                b += 40;
            degrees += (b - c) * dpt;
            dc.write(degrees + "\n");
        }

        dc.close();
        sc.close();
    }
}