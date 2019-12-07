import java.io.*;
import java.util.*;

public class apaxianparent {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String y = sc.next();
        String p = sc.next();
        if (y.matches(".*[aioue]$"))
            System.out.println(y.substring(0, y.length() - 1) + "ex" + p);
        else if (y.endsWith("ex"))
            System.out.println(y + p);
        else
            System.out.println(y + "ex" + p);
    }
}