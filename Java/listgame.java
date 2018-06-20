
// https://open.kattis.com/problems/listgame

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class listgame {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(sc.readLine());
        int count = 0;

        while (num % 2 == 0) {
            num /= 2;
            count++;
        }

        for (int x = 3; x <= (int) Math.sqrt(num); x += 2)
            while (num % x == 0) {
                num /= x;
                count++;
            }

        if (num > 2)
            count++;

        dc.write(count + "\n");

        dc.flush();
        dc.close();
        sc.close();
    }
}