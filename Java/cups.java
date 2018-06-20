
// https://open.kattis.com/problems/cups
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class cups {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeMap<Integer, String> orderOfCups = new TreeMap<>();
        int cups = sc.nextInt();
        sc.nextLine();
        while (cups-- > 0) {
            String line = sc.nextLine();
            String[] description = line.split(" ");
            int radius;
            String color;

            if ((int) description[0].charAt(0) >= 48 && (int) description[0].charAt(0) <= 57) {
                radius = Integer.parseInt(description[0])/2;
                color = description[1];
            } else {
                radius = Integer.parseInt(description[1]);
                color = description[0];
            }
            orderOfCups.put(radius, color);
        }
        for (Map.Entry<Integer, String> s : orderOfCups.entrySet())
            System.out.println(s.getValue());
        sc.close();
    }
}