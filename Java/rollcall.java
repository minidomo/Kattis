import java.io.*;
import java.util.*;

public class rollcall {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> fname = new HashMap<>();
        ArrayList<String> names = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            names.add(line);
            String first = line.substring(0, line.indexOf(' '));
            fname.put(first, fname.containsKey(first) ? fname.get(first) + 1 : 1);
        }
        Collections.sort(names, new Comparator<String>() {
            public int compare(String a, String b) {
                String[] q = a.split(" ");
                String[] w = b.split(" ");
                int dif = q[1].compareTo(w[1]);
                return dif == 0 ? q[0].compareTo(w[0]) : dif;
            }
        });
        for (String name : names) {
            String first = name.substring(0, name.indexOf(' '));
            if (fname.get(first) > 1)
                System.out.println(name);
            else
                System.out.println(first);
        }
        sc.close();
    }
}