
//  https://open.kattis.com/problems/speedlimit
import java.util.Scanner;

public class speedlimit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean isNegOne = false;
        while (!isNegOne) {
            int pairs = sc.nextInt();
            if (pairs == -1) {
                isNegOne = true;
            } else {
                int[] speedTime = new int[pairs * 2];
                for (int x = 0; x < speedTime.length; x++)
                    speedTime[x] = sc.nextInt();

                int distance = speedTime[0] * speedTime[1];
                for (int s = 2; s < speedTime.length; s += 2)
                    distance += (speedTime[s + 1] - speedTime[s - 1]) * speedTime[s];
                System.out.println(distance + " miles");
            }
        }
        sc.close();
    }
}