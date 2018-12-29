import java.io.*;
import java.util.*;

public class owlandfox {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        while (cases-- > 0) {
            int n = sc.nextInt();
            int t = n;
            int pow = 1;
            while (t % 10 == 0) {
                pow *= 10;
                t /= 10;
            }
            System.out.println(n - pow);
        }
        sc.close();
    }
}