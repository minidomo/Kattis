import java.io.*;
import java.util.*;

public class erase {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String a = sc.nextLine();
        String b = sc.nextLine();
        if ((n & 1) == 1)
            System.out.println(a.replace('1', ' ').replace('0', '1').replace(' ', '0').equals(b) ? "Deletion succeeded"
                    : "Deletion failed");
        else
            System.out.println(a.equals(b) ? "Deletion succeeded" : "Deletion failed");
        sc.close();
    }
}