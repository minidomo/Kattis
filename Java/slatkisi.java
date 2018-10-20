import java.io.*;
import java.util.*;

public class slatkisi {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] tokens = sc.readLine().split(" ");
        int price = Integer.parseInt(tokens[0]);
        int zeros = Integer.parseInt(tokens[1]);
        dc.write(round(price, zeros) + "\n");
        dc.close();
        sc.close();
    }

    private static int round(int num, int places) {
        double pow = Math.pow(10, places);
        return (int) (Math.round(num / pow) * pow);
    }
}