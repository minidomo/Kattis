
// https://open.kattis.com/problems/synchronizinglists
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class synchronizinglists {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int num = sc.nextInt();
            if (num == 0)
                break;
            int[] first = new int[num];
            for (int x = 0; x < num; x++)
                first[x] = sc.nextInt();

            int[] sec = new int[num];
            for (int x = 0; x < num; x++)
                sec[x] = sc.nextInt();

            int[] temp = new int[num];
            int i = 0;
            for (int x : first)
                temp[i++] = x;
            Arrays.sort(temp);
            Arrays.sort(sec);

            TreeMap<Integer, Integer> sync = new TreeMap<>();
            for (int x = 0; x < num; x++)
                sync.put(temp[x], sec[x]);

            for (int x : first)
                System.out.println(sync.get(x));
            System.out.println();
        }
        sc.close();
    }
}
