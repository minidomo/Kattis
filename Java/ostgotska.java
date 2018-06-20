
// https://open.kattis.com/problems/ostgotska
import java.util.Scanner;

public class ostgotska {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] words = sc.nextLine().split(" ");
        double count = 0;
        for (String s : words)
            if (s.contains("ae"))
                count++;
        System.out.println(count / words.length >= .4 ? "dae ae ju traeligt va" : "haer talar vi rikssvenska");
        sc.close();
    }
}
