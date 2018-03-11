
// Runtime: 0.10 s
// https://open.kattis.com/problems/bard
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class bard {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        OutputStream dc = new BufferedOutputStream(System.out);

        int villagers = Integer.parseInt(sc.readLine());
        int evenings = Integer.parseInt(sc.readLine());

        TreeMap<Integer, String> people = new TreeMap<>();
        for (int x = 1; x <= villagers; x++)
            people.put(x, "0");

        int songs = 0;

        while (evenings-- > 0) {
            String[] line = sc.readLine().split(" ");
            int present = Integer.parseInt(line[0]);
            int[] who = new int[present];
            for (int x = 0; x < present; x++)
                who[x] = Integer.parseInt(line[x + 1]);

            Arrays.sort(who);
            if (who[0] == 1) {
                songs++;
                for (int x : who)
                    people.put(x, people.get(x) + " " + songs);
            } else {
                TreeSet<Integer> share = new TreeSet<>();
                for (int x : who) {
                    String songsListen = people.get(x);
                    for (String s : songsListen.split(" "))
                        share.add(Integer.parseInt(s));
                }
                String replace = "";
                int[] nums = new int[share.size()];
                int a = 0;
                for (int s : share)
                    nums[a++] = s;

                for (int x = 0; x < nums.length; x++)
                    replace += x == nums.length - 1 ? nums[x] : nums[x] + " ";

                for (int x : who)
                    people.put(x, replace);
            }
        }
        for (Map.Entry<Integer, String> x : people.entrySet())
            if (x.getValue().equals(people.get(1)))
                dc.write((x.getKey() + "\n").getBytes());
        sc.close();
        dc.flush();
    }
}
