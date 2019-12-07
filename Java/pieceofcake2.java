import java.io.*;
import java.util.*;

public class pieceofcake2 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int h = sc.nextInt();
        int v = sc.nextInt();
        System.out.println(Math.max(h, n - h) * Math.max(v, n - v) * 4);
    }
}