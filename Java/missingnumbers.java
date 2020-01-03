import java.io.*;
import java.util.*;

public class missingnumbers {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        boolean[] arr = new boolean[201];
        int n = sc.nextInt();
        int last = 0;
        while (n-- > 0) {
            int x = sc.nextInt();
            arr[x] = true;
            last = x;
        }
        boolean fail = false;
        for (int x = 1; x <= last; x++) {
            if (!arr[x]) {
                fail = true;
                System.out.println(x);
            }
        }
        if (!fail)
            System.out.println("good job");
    }
}