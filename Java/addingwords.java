
// https://open.kattis.com/problems/addingwords
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class addingwords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> definitions = new HashMap<>();

        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split(" ");
            String action = line[0];
            if (action.equals("def"))
                definitions.put(line[1], Integer.parseInt(line[2]));
            else if (action.equals("clear"))
                definitions.clear();
            else {
                for (int x = 1; x < line.length; x++)
                    System.out.print(line[x] + " ");

                boolean hasDef = true;
                for (int x = 1; x < line.length; x += 2)
                    if (!definitions.containsKey(line[x])) {
                        hasDef = false;
                        break;
                    }
                if (!hasDef)
                    System.out.println("unknown");
                else {
                    int sum = definitions.get(line[1]);
                    for (int x = 2; x < line.length - 1; x += 2) {
                        if (line[x].equals("-"))
                            sum -= definitions.get(line[x + 1]);
                        else
                            sum += definitions.get(line[x + 1]);
                    }
                    boolean unknown = true;
                    for (Map.Entry<String, Integer> s : definitions.entrySet())
                        if (sum == s.getValue()) {
                            System.out.println(s.getKey());
                            unknown = false;
                        }
                    if (unknown)
                        System.out.println("unknown");
                }
            }
        }
        sc.close();
    }
}