import java.io.*;
import java.util.*;

public class averagespeed {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));
        String line;
        int[] arr = { 0, 0, 0, 0 };
        double dist = 0;
        while ((line = sc.readLine()) != null) {
            String[] arr1 = line.split("[:\\s]");
            int h = Integer.parseInt(arr1[0]) * 3600;
            int m = Integer.parseInt(arr1[1]) * 60;
            int s = Integer.parseInt(arr1[2]);
            int pastSec = h + m + s - arr[0] - arr[1] - arr[2];
            double prop = pastSec / 3600d;
            dist += prop * arr[3];
            arr[0] = h;
            arr[1] = m;
            arr[2] = s;
            if (arr1.length == 4)
                arr[3] = Integer.parseInt(arr1[3]);
            else
                dc.write(String.format("%s:%s:%s %.2f km\n", arr1[0], arr1[1], arr1[2], dist));
        }
        dc.close();
        sc.close();
    }
}