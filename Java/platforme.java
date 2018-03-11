
// https://open.kattis.com/problems/platforme
import java.util.ArrayList;
import java.util.Arrays;
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

        ranges = numPartnerSort(yCoords, ranges);

        int total = 0;

        for (int s = 0; s < yCoords.length; s++) {
            int y1 = yCoords[s];
            String[] temp1 = ranges[s].split(" ");
            double x1 = Double.parseDouble(temp1[0]);
            double x2 = Double.parseDouble(temp1[1]);
            int leftPillar = 0;
            int rightPillar = 0;

            for (int x = 0; x < yCoords.length; x++) {
                int y2 = yCoords[x];
                String[] temp2 = ranges[x].split(" ");
                double lx = Double.parseDouble(temp2[0]);
                double rx = Double.parseDouble(temp2[1]);

                if (y1 > y2) {
                    if (x1 >= lx && x1 <= rx)
                        leftPillar = y2;
                    if (x2 >= lx && x2 <= rx)
                        rightPillar = y2;
                }
            }
            total += (y1 - leftPillar) + (y1 - rightPillar);
        }
        System.out.println(total);
        sc.close();
    }

    private static String[] numPartnerSort(int[] key, String[] value) {
        // similar to the way a treemap sorts but with duplicates
        ArrayList<Integer> keyList = new ArrayList<>();
        ArrayList<String> valueList = new ArrayList<>();
        ArrayList<String> sorted = new ArrayList<>();

        for (int x = 0; x < key.length; x++) {
            keyList.add(key[x]);
            valueList.add(value[x]);
        }

        while (keyList.size() != 0) {
            int small = keyList.get(0);
            int index = 0;
            for (int x = 0; x < keyList.size(); x++)
                if (keyList.get(x) < small) {
                    small = keyList.get(x);
                    index = x;
                }
            keyList.remove(index);
            sorted.add(valueList.remove(index));
        }

        String[] sortVal = new String[sorted.size()];
        int i = 0;
        for (String s : sorted)
            sortVal[i++] = s;

        Arrays.sort(key);
        return sortVal;
    }
}