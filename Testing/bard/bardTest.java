import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class bardTest {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("test.txt"));
        // Scanner sc = new Scanner(System.in);

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

                // System.out.println(people);
            } else {
                TreeSet<Integer> share = new TreeSet<>();
                for (int x : who) {
                    String songsListen = people.get(x);
                    String[] nums = songsListen.split(" ");
                    for (String s : nums)
                        share.add(Integer.parseInt(s));

                    // for (int s = 0; s < songsListen.length(); s++)
                    //     if (canParse("" + songsListen.charAt(s)))
                    //         share.add(Integer.parseInt("" + songsListen.charAt(s)));
                }

                // System.out.println(share);

                String replace = "";
                for (int x = 0; x < share.size(); x++)
                    replace += x == share.size() - 1 ? x : x + " ";
                // for (int x : share)
                //     replace += x + " ";

                // System.out.println(replace);

                for (int x : who)
                    people.put(x, replace);
            }
        }
        // System.out.println("songs: " + songs);
        // System.out.println(people);
        // for (Map.Entry<Integer, Integer> x : people.entrySet())
        //     if (x.getValue() == songs)
        //         System.out.println(x.getKey());
        for (Map.Entry<Integer, String> x : people.entrySet())
            if (x.getValue().equals(people.get(1)))
                System.out.println(x.getKey());

        // System.out.println();
        // for (Map.Entry<Integer, String> x : people.entrySet())
        //     System.out.println(x.getKey() + ": " + x.getValue());

        sc.close();
    }
}
