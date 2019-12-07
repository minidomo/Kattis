import java.io.*;
import java.util.*;

public class lostlineup {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt() - 1;
        int[] arr = new int[n];
        for (int x = 1; x <= n; x++)
            arr[sc.nextInt()] = x + 1;
        System.out.print(1 + " ");
        for (int x : arr)
            System.out.print(x + " ");
    }
}