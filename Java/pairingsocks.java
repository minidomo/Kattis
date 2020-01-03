import java.io.*;
import java.util.*;

public class pairingsocks {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> a = new Stack<>();
        for (int x = 0; x < n * 2; x++) {
            int q = sc.nextInt();
            if (a.isEmpty() || a.peek() != q)
                a.push(q);
            else
                a.pop();
        }
        System.out.println(a.isEmpty() ? n * 2 + "" : "impossible");
    }
}