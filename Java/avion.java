import java.io.*;
import java.util.*;

public class avion {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int x = 1;
        int count = 0;
        while (sc.hasNext()) {
            if (sc.next().contains("FBI")) {
                System.out.print(x + " ");
                count++;
            }
            x++;
        }
        if (count == 0)
            System.out.println("HE GOT AWAY!");
    }
}