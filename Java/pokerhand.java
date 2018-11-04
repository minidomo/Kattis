import java.io.*;
import java.util.*;

public class pokerhand {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[100];
        int max = -1, c = ' ';
        for (String s : sc.readLine().split(" "))
            if (++arr[c = s.charAt(0)] > max)
                max = arr[c];
        dc.write(max + "\n");

        dc.close();
        sc.close();
    }
}