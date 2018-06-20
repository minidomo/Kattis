
// https://open.kattis.com/problems/parking
import java.util.Arrays;
import java.util.Scanner;

public class parking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int price1 = sc.nextInt(), price2 = sc.nextInt() * 2, price3 = sc.nextInt() * 3;
        int[] times = new int[6];
        for (int x = 0; x < times.length; x++)
            times[x] = sc.nextInt();
        int min1 = times[0], max1 = times[1];
        int min2 = times[2], max2 = times[3];
        int min3 = times[4], max3 = times[5];
        int total = 0;
        Arrays.sort(times);
        int min = times[0], max = times[5];

        for (int x = min; x < max; x++) {
            int count = 0;
            if (x >= min1 && x < max1)
                count++;
            if (x >= min2 && x < max2)
                count++;
            if (x >= min3 && x < max3)
                count++;
            total += count == 1 ? price1 : count == 2 ? price2 : count == 3 ? price3 : 0;
        }
        System.out.println(total);
        sc.close();
    }
}