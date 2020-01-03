import java.io.*;
import java.util.*;

public class astro {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\\s+|:");
        boolean[] arr = new boolean[(int) 1e7];
        String[] dow = { "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" };
        int f = sc.nextInt() * 60 + sc.nextInt();
        int s = sc.nextInt() * 60 + sc.nextInt();
        int frate = sc.nextInt() * 60 + sc.nextInt();
        int srate = sc.nextInt() * 60 + sc.nextInt();
        for (int x = f; x < arr.length; x += frate)
            arr[x] = true;
        for (int x = s; x < arr.length; x += srate)
            if (arr[x]) {
                int day = x / 24 / 60 % 7;
                System.out.println(dow[day]);
                System.out.printf("%02d:%02d", x / 60 % 24, x % 60);
                return;
            }
        System.out.println("Never");
    }
}