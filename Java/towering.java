
//	https://open.kattis.com/problems/towering
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class towering {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> boxes = new ArrayList<>();
        int[] towers = new int[2];
        Integer[] firstTower = new Integer[3];
        Integer[] secondTower = new Integer[3];

        for (int x = 0; x < 6; x++)
            boxes.add(sc.nextInt());
        for (int x = 0; x < 2; x++)
            towers[x] = sc.nextInt();

        for (int x : boxes)
            for (int z : boxes)
                for (int c : boxes)
                    if (x + z + c == towers[0] && x != z && z != c && x != c) {
                        firstTower[0] = z;
                        firstTower[1] = x;
                        firstTower[2] = c;
                    }

        for (int x = 0; x < 3; x++)
            boxes.remove(boxes.indexOf(firstTower[x]));

        for (int x = 0; x < 3; x++)
            secondTower[x] = boxes.get(x);

        Arrays.sort(firstTower, Collections.reverseOrder());
        Arrays.sort(secondTower, Collections.reverseOrder());
        for (int x : firstTower)
            System.out.print(x + " ");
        for (int x : secondTower)
            System.out.print(x + " ");
        sc.close();
    }
}