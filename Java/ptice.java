import java.io.*;
import java.util.*;

public class ptice {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String[] keys = { "ABC", "BABC", "CCAABB" };
        int n = sc.nextInt();
        String ans = sc.next();
        int[] count = new int[3];
        for (int x = 0; x < n; x++) {
            char c = ans.charAt(x);
            for (int i = 0; i < 3; i++)
                if (c == keys[i].charAt(x % keys[i].length()))
                    count[i]++;
        }
        int max = 0;
        for (int x = 0; x < 3; x++)
            max = Math.max(max, count[x]);
        System.out.println(max);
        for (int x = 0; x < 3; x++) {
            if (max == count[x]) {
                if (x == 0)
                    System.out.println("Adrian");
                else if (x == 1)
                    System.out.println("Bruno");
                else
                    System.out.println("Goran");
            }
        }
    }
}