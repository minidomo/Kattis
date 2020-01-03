import java.io.*;
import java.util.*;

public class hangman {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] arr = sc.next().toCharArray();
        int count = 0;
        for (int x = 0; x < arr.length; x++) {
            if (s.contains(arr[x] + ""))
                s = s.replace(arr[x] + "", "");
            else
                count++;
            if (s.length() == 0) {
                System.out.println("WIN");
                return;
            } else if (count == 10) {
                System.out.println("LOSE");
                return;
            }
        }
    }
}