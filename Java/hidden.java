import java.util.*;
import java.io.*;

public class hidden {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] tokens = sc.readLine().split(" ");
        char[] arr = tokens[1].toCharArray();
        String result = "";
        for (int x = 0; x < tokens[0].length(); x++) {
            check: {
                for (int a = 0; a < arr.length; a++)
                    for (int d = x; d < tokens[0].length(); d++)
                        if (arr[a] == tokens[0].charAt(d)) {
                            result += arr[a];
                            arr[a] = ' ';
                            break check;
                        }
            }
        }
        dc.write(result.equals(tokens[0]) ? "PASS" : "FAIL");

        dc.close();
        sc.close();
    }
}