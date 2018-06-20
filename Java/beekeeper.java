
// https://open.kattis.com/problems/beekeeper
import java.util.Arrays;
import java.util.Scanner;

public class beekeeper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] vowels = { "aa", "ee", "ii", "oo", "uu", "yy" };

        while (true) {
            int cases = sc.nextInt();
            if (cases == 0)
                break;
            sc.nextLine();

            String[] words = new String[cases];
            for (int x = 0; x < cases; x++)
                words[x] = sc.nextLine();

            int[] score = new int[cases];
            int q = 0;
            for (String s : words) {
                String temp = s;
                for (int x = 0; x < 2; x++)
                    for (int a = 0; a < vowels.length; a++)
                        if (temp.contains(vowels[a])) {
                            int index = temp.indexOf(vowels[a]);
                            temp = new StringBuilder(temp).replace(index, index + 2, "00").toString();
                            score[q]++;
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

            System.out.println(words[index]);
        }

        sc.close();
    }
}
