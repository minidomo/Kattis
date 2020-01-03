import java.io.*;
import java.util.*;

public class moscowdream {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(a > 0 && b > 0 && c > 0 && a + b + c >= n && n >= 3 ? "YES" : "NO");
    }
}