
// https://open.kattis.com/problems/birds
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Arrays;

public class birds {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        OutputStream dc = new BufferedOutputStream(System.out);

        String[] nums = sc.readLine().split(" ");
        int length = Integer.parseInt(nums[0]);
        int distance = Integer.parseInt(nums[1]);
        int currentlyOn = Integer.parseInt(nums[2]);
        int[] positions = new int[currentlyOn];
        if (length <= 12)
            dc.write(("0").getBytes());
        else {
            int count = 0;
            if (currentlyOn == 0) {
                int distanceCanUse = length - 12;
                count += (distanceCanUse / distance) + 1;
            } else {
                for (int x = 0; x < currentlyOn; x++)
                    positions[x] = Integer.parseInt(sc.readLine());

                Arrays.sort(positions);
                int leftDist = positions[0] - 6;
                int rightDist = (length - 6) - positions[positions.length - 1];
                count += (leftDist / distance) + (rightDist / distance);

                for (int x = 0; x < currentlyOn - 1; x++) {
                    int distanceBtwn = positions[x + 1] - positions[x];
                    count += (distanceBtwn / distance) - 1;
                }
            }
            dc.write((count + "").getBytes());
        }
        sc.close();
        dc.flush();
    }
}