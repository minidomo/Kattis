
// https://open.kattis.com/problems/icpcawards
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class icpcawards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String, String> teams = new LinkedHashMap<>();

        int cases = sc.nextInt();
        sc.nextLine();
        while (cases-- > 0) {
            String place = sc.next();
            String name = " " + sc.next();
            if (!teams.containsKey(place) && teams.size() < 12)
                teams.put(place, name);
        }
        for (Map.Entry<String, String> s : teams.entrySet())
            System.out.println(s.getKey() + s.getValue());
        sc.close();
    }
}