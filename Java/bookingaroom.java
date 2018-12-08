import java.io.*;
import java.util.*;

public class bookingaroom {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = sc.readLine().split(" ");
        boolean[] rooms = new boolean[Integer.parseInt(arr[0]) + 1];
        int booked = Integer.parseInt(arr[1]);
        while (booked-- > 0)
            rooms[Integer.parseInt(sc.readLine())] = true;
        boolean found = false;
        for (int x = 1; x < rooms.length; x++)
            if (!rooms[x]) {
                dc.write(x + "\n");
                found = true;
                break;
            }
        if (!found)
            dc.write("too late\n");
        dc.close();
        sc.close();
    }
}