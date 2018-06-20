
// https://open.kattis.com/problems/hissingmicrophone
import java.util.Scanner;

public class hissingmicrophone {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(sc.nextLine().contains("ss") ? "hiss" : "no hiss");
        sc.close();
    }
}