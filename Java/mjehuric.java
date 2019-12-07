import java.io.*;
import java.util.*;

public class mjehuric {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        int[] arr = new int[line.length];
        for (int x = 0; x < line.length; x++)
            arr[x] = Integer.parseInt(line[x]);
        int x = 0;
        boolean done = false;
        while (!done) {
            done = true;
            for (int a = 0; a < arr.length - 1; a++) {
                if (arr[a] > arr[a + 1]) {
                    int t = arr[a];
                    arr[a] = arr[a + 1];
                    arr[a + 1] = t;
                    for (int q = 0; q < arr.length; q++)
                        System.out.print(arr[q] + " ");
                    System.out.println();
                    done = false;
                }
            }
            x++;
        }
    }
}