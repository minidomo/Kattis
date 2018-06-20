
// https://open.kattis.com/problems/birds
import java.util.Arrays;
import java.util.Scanner;

public class birds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int length = sc.nextInt();
        int distance = sc.nextInt();
        int currentlyOn = sc.nextInt();
        int[] positions = new int[currentlyOn];
        if (length <= 12)
            System.out.println(0);
        else {
            int count = 0;
            if (currentlyOn == 0) {
                int distanceCanUse = length - 12;
                count += (distanceCanUse / distance) + 1;
            } else {
                for (int x = 0; x < currentlyOn; x++)
                    positions[x] = sc.nextInt();

                Arrays.sort(positions);
                int leftDist = positions[0] - 6;
                int rightDist = (length - 6) - positions[positions.length - 1];
                count += (leftDist / distance) + (rightDist / distance);

                for (int x = 0; x < currentlyOn - 1; x++) {
                    int distanceBtwn = positions[x + 1] - positions[x];
                    count += (distanceBtwn / distance) - 1;
                }
            }
            System.out.println(count);
        }

        sc.close();
    }
}