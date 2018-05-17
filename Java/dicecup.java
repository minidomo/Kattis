
// https://open.kattis.com/problems/dicecup
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class dicecup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> sums = new ArrayList<>();

        int face1 = sc.nextInt();
        int face2 = sc.nextInt();
        for (int x = 1; x <= face1; x++)
            for (int z = 1; z <= face2; z++)
                sums.add(z + x);

        TreeSet<Integer> noDuplicates = new TreeSet<>(sums);
        TreeSet<Integer> mostRepetitive = new TreeSet<>();
        int highestRepetition = 1;
        for (int z = 0; z < 2; z++) {
            for (int s : noDuplicates) {
                int count = 0;
                for (int x : sums) {
                    if (x == s) {
                        count++;
                        if (z == 0) {
                            if (count > highestRepetition)
                                highestRepetition = count;
                        } else {
                            if (count == highestRepetition)
                                mostRepetitive.add(s);
                        }
                    }
                }
            }
        }
        for (int s : mostRepetitive)
            System.out.println(s);
        sc.close();
    }
}