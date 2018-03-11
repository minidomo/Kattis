
// https://open.kattis.com/problems/platforme
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class platforme {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        OutputStream dc = new BufferedOutputStream(System.out);

        int platforms = Integer.parseInt(sc.readLine());
        int[] yCoords = new int[platforms];
        double[] leftx = new double[platforms];
        double[] rightx = new double[platforms];

        for (int x = 0; x < platforms; x++) {
            String[] nums = sc.readLine().split(" ");
            yCoords[x] = Integer.parseInt(nums[0]);
            leftx[x] = Double.parseDouble(nums[1]) + .5;
            rightx[x] = Double.parseDouble(nums[2]) - .5;
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
        dc.write((total + "\n").getBytes());
        sc.close();
        dc.flush();
    }
}
