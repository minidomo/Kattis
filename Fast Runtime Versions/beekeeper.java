
// Runtime: 0.05 s
// https://open.kattis.com/problems/beekeeper
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class beekeeper {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        OutputStream dc = new BufferedOutputStream(System.out);

        String[] vowels = { "aa", "ee", "ii", "oo", "uu", "yy" };

        while (true) {
            int cases = Integer.parseInt(sc.readLine());
            if (cases == 0)
                break;

            String[] words = new String[cases];
            for (int x = 0; x < cases; x++)
                words[x] = sc.readLine();

            int[] score = new int[cases];
            int q = 0;
            for (String s : words) {
                String temp = s;
                for (int x = 0; x < 2; x++)
                    for (int a = 0; a < vowels.length; a++) {
                        if (temp.contains(vowels[a])) {
                            int index = temp.indexOf(vowels[a]);
                            temp = new StringBuilder(temp).replace(index, index + 2, "00").toString();
                            score[q]++;
                        }
                    }
                q++;
            }

            int highest = score[0];
            int index = 0;
            for (int x = 0; x < score.length; x++)
                if (score[x] > highest) {
                    highest = score[x];
                    index = x;
                }
            dc.write((words[index] + "\n").getBytes());
        }

        sc.close();
        dc.flush();
    }
}
