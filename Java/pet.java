
// https://open.kattis.com/problems/pet
import java.util.Scanner;
import java.util.TreeMap;

public class pet {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> points = new TreeMap<>();
        Scanner sc = new Scanner(System.in);

        for (int x = 1; x < 6; x++) {
            int total = 0;
            total += sc.nextInt() + sc.nextInt() + sc.nextInt() + sc.nextInt();
            points.put(total, x);
        }
        System.out.println(points.get(points.lastKey()) + " " + points.lastKey());
        sc.close();
    }
}