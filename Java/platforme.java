
// https://open.kattis.com/problems/platforme
import java.util.Scanner;

public class platforme {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int platforms = sc.nextInt();
        sc.nextLine();
        int[] yCoords = new int[platforms];
        double[] leftx = new double[platforms];
        double[] rightx = new double[platforms];

        for (int x = 0; x < platforms; x++) {
            String[] temp = sc.nextLine().split(" ");
            yCoords[x] = Integer.parseInt(temp[0]);
            leftx[x] = Double.parseDouble(temp[1]) + .5;
            rightx[x] = Double.parseDouble(temp[2]) - .5;
        }

        int total = 0;

        for (int s = 0; s < platforms; s++) {
            int y1 = yCoords[s];
            double x1 = leftx[s];
            double x2 = rightx[s];
            int leftPillar = 0;
            int rightPillar = 0;

            for (int x = 0; x < platforms; x++) {
                int y2 = yCoords[x];
                if (y1 > y2) {
                    double lx = leftx[x];
                    double rx = rightx[x];
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
