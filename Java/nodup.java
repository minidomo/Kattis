
// https://open.kattis.com/problems/nodup
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class nodup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] words = sc.nextLine().split(" ");
        HashSet<String> noDup = new HashSet<>(Arrays.asList(words));
        System.out.println(words.length == noDup.size() ? "yes" : "no");
        sc.close();
    }
}