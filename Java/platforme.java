
// https://open.kattis.com/problems/platforme
import java.util.Scanner;

public class platforme {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int platforms = sc.nextInt();
        int[] yCoords = new int[platforms];
        String[] ranges = new String[platforms];

        for (int x = 0; x < platforms; x++) {
            yCoords[x] = sc.nextInt();
            ranges[x] = (sc.nextDouble() + .5) + " " + (sc.nextDouble() - .5);
        }

        int total = 0;

        for (int s = 0; s < platforms; s++) {
            int y1 = yCoords[s];
            String[] temp1 = ranges[s].split(" ");
            double x1 = Double.parseDouble(temp1[0]);
            double x2 = Double.parseDouble(temp1[1]);
            int leftPillar = 0;
            int rightPillar = 0;

            for (int x = 0; x < platforms; x++) {
                int y2 = yCoords[x];
                String[] temp2 = ranges[x].split(" ");
                double lx = Double.parseDouble(temp2[0]);
                double rx = Double.parseDouble(temp2[1]);

                if (y1 > y2) {
                    if (x1 >= lx && x1 <= rx && y2 > leftPillar)
                        leftPillar = y2;
                    if (x2 >= lx && x2 <= rx && y2 > rightPillar)
                        rightPillar = y2;
                }
            }
            total += (y1 - leftPillar) + (y1 - rightPillar);
        }
        System.out.println(total);
        sc.close();
    }
}
