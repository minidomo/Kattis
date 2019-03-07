import java.io.*;
import java.util.*;

public class rationalsequence2 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        while (N-- > 0) {
            System.out.print(sc.nextInt() + " ");
            String[] line = sc.nextLine().trim().split("/");
            Pair cur = new Pair(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
            ArrayDeque<Pair> arr = new ArrayDeque<>();
            while (cur.f != 1 || cur.s != 1) {
                arr.offerFirst(new Pair(cur.f, cur.s));
                if (cur.f > cur.s)
                    cur.f -= cur.s;
                else
                    cur.s -= cur.f;
            }
            int x = 1;
            while (!arr.isEmpty()) {
                Pair a = arr.poll();
                x *= 2;
                if (a.f > a.s)
                    x++;
            }
            System.out.println(x);
        }
        sc.close();
    }
}

class Pair {
    public int f, s;

    public Pair(int a, int b) {
        f = a;
        s = b;
    }
}