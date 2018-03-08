import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class bard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int villagers = sc.nextInt();
        int evenings = sc.nextInt();

        TreeMap<Integer, String> people = new TreeMap<>();
        for (int x = 1; x <= villagers; x++)
            people.put(x, "0");

        int songs = 0;

        while (evenings-- > 0) {
            int present = sc.nextInt();
            ArrayList<Integer> who = new ArrayList<>();

            while (present-- > 0) {
                who.add(sc.nextInt());
            }

            if (who.contains(1)) {
                songs++;
                for (int x : who)
                    people.put(x, people.get(x) + " " + songs);
            } else {
                TreeSet<String> share = new TreeSet<>();
                for (int x : who) {
                    String songsListen = people.get(x);
                    String[] nums = songsListen.split(" ");
                    for (String s : nums)
                        share.add(s);
                }
                String replace = "";
                for (int x = 0; x < share.size(); x++)
                    replace += x == share.size() - 1 ? x : x + " ";

                for (int x : who)
                    people.put(x, replace);
            }
        }
        for (Map.Entry<Integer, String> x : people.entrySet())
            if (x.getValue().equals(people.get(1)))
                System.out.println(x.getKey());
        sc.close();
    }
}