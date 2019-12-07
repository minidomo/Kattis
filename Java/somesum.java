import java.io.*;
import java.util.*;

public class somesum {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 1) {
            System.out.println("Either");
            return;
        }
        double half = n / 2d;
        int h1 = (int) Math.floor(half);
        int h2 = (int) Math.ceil(half);
        if (h1 == h2)
            if (h1 % 2 == 1)
                System.out.println("Odd");
            else
                System.out.println("Even");
        else
            System.out.println("Either");
    }
}