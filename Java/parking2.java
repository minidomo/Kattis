
// https://open.kattis.com/problems/parking2
import java.util.Arrays;
import java.util.Scanner;

public class parking2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();
        while (cases-- > 0) {
            int stores = sc.nextInt();
            int[] position = new int[stores];
            for (int x = 0; x < stores; x++)
                position[x] = sc.nextInt();
            Arrays.sort(position);

            int distance = 0;
            for (int x = 1; x <= stores; x++)
                distance += x == stores ? position[x - 1] - position[0] : position[x] - position[x - 1];
            System.out.println(distance);
        }

        sc.close();
    }
}