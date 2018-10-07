import java.util.*;
import java.io.*;

public class reseto {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] tokens = sc.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]);
        int k = Integer.parseInt(tokens[1]);

        boolean[] arr = new boolean[n + 1];
        int count = 0;
        sieve: {
            for (int x = 2; x < arr.length; x++) {
                if (!arr[x]) {
                    count++;
                    if (count == k) {
                        dc.write(x + "\n");
                        break sieve;
                    }
                    for (int a = x * 2; a < arr.length; a += x) {
                        if (!arr[a]) {
                            arr[a] = true;
                            count++;
                            if (count == k) {
                                dc.write(a + "\n");
                                break sieve;
                            }
                        }
                    }
                }
            }
        }
        dc.close();
        sc.close();
    }
}