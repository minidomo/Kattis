import java.util.*;
import java.io.*;

public class recount {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();
        int max = -1;
        String winner = null;
        for (;;) {
            String name = sc.nextLine();
            if (name.equals("***"))
                break;
            map.put(name, map.containsKey(name) ? map.get(name) + 1 : 1);
            int val = map.get(name);
            if (val > max) {
                winner = name;
                max = val;
            } else if (val == max) {
                winner = null;
            }
        }
        System.out.println(winner == null ? "Runoff!" : winner);
        sc.close();
    }
}