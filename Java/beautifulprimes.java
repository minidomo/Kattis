import java.util.*;
import java.io.*;

public class beautifulprimes {

    private static int[] primes;

    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        primes = new int[1000001];
        primes[0] = primes[1] = -1;
        for (int x = 2; x * x < primes.length; x++)
            if (primes[x] == 0)
                for (int a = x * 2; a < primes.length; a += x)
                    primes[a] = -1;

        String[] arr = new String[1001];
        arr[1] = "5";
        double val = Math.log10(5);
        for (int x = 2; x < arr.length; x++) {
            double diff = x - 1 - val;
            int prime = nextPrime(diff);
            arr[x] = arr[x - 1] + " " + prime;
            val += Math.log10(prime);
        }

        int cases = Integer.parseInt(sc.readLine());
        while (cases-- > 0) {
            dc.write(arr[Integer.parseInt(sc.readLine())] + "\n");
            dc.flush();
        }

        dc.close();
        sc.close();
    }

    private static int nextPrime(double diff) {
        int min = (int) Math.ceil(Math.pow(10, diff));
        int start = (int) Math.ceil(min / 6d) * 6;
        for (int x = start;; x += 6) {
            if (x - 1 > min && primes[x - 1] == 0)
                return x - 1;
            if (x + 1 > min && primes[x + 1] == 0)
                return x + 1;
        }
    }
}