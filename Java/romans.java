import java.util.*;
import java.io.*;

public class romans {
    public static void main(String[] args) throws Exception {
        System.out
                .println(Math.round(Double.parseDouble(new BufferedReader(new InputStreamReader(System.in)).readLine())
                        * 1000 * 5280 / 4854));
    }
}