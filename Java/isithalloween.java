import java.io.*;
import java.util.*;

public class isithalloween {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = sc.readLine();
        dc.write(s.equals("OCT 31") || s.equals("DEC 25") ? "yup" : "nope");

        dc.close();
        sc.close();
    }
}