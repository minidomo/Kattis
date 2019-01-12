import java.io.*;
import java.util.*;

public class natrij {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String[] cur = sc.nextLine().split(":");
        String[] end = sc.nextLine().split(":");
        int current = Integer.parseInt(cur[0]) * 3600 + Integer.parseInt(cur[1]) * 60 + Integer.parseInt(cur[2]);
        int endtime = Integer.parseInt(end[0]) * 3600 + Integer.parseInt(end[1]) * 60 + Integer.parseInt(end[2]);
        int duration;
        if (current < endtime)
            duration = endtime - current;
        else
            duration = 24 * 3600 - current + endtime;
        int hours = duration / 3600;
        duration %= 3600;
        int mins = duration / 60;
        System.out.printf("%02d:%02d:%02d", hours, mins, duration % 60);
        sc.close();
    }
}