import java.io.*;
import java.util.*;

public class jobexpenses {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        while (n-- > 0)
            sum = Math.max(sum, sum - sc.nextInt());
        System.out.println(sum);
    }
}