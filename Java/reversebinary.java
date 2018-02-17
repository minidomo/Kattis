
// https://open.kattis.com/problems/reversebinary
import java.util.Scanner;

public class reversebinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String binary = Integer.toBinaryString(sc.nextInt());
        String swap = "";
        for (int s = binary.length() - 1; 0 <= s; s--)
            swap += binary.charAt(s);
        System.out.println(Integer.parseInt(swap, 2));
        sc.close();
    }
}