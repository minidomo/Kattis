
// https://open.kattis.com/problems/sortofsorting
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class sortofsorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // I just wanted to change it up
        for (;;) {
            int cases = sc.nextInt();
            sc.nextLine();
            if (cases == 0)
                break;
            TreeSet<String> people = new TreeSet<>();
            while (cases-- > 0) {
                String s = sc.nextLine();
                String pre = "" + s.charAt(0) + s.charAt(1);
                people.add(s + howMany(people, pre));
            }

            ArrayList<String> wait = new ArrayList<>();
            ArrayList<Integer> num = new ArrayList<>();

            for (String s : people) {
                int numIndex = 0;
                for (int x = 1; x < s.length(); x++)
                    if (s.charAt(x) >= '0' && s.charAt(x) <= '9') {
                        numIndex = x;
                        break;
                    }

                String name = s.substring(0, numIndex);
                int order = Integer.parseInt(s.substring(numIndex));

                if (!wait.isEmpty()) {
                    String a = wait.get(0);
                    String pre = "" + a.charAt(0) + a.charAt(1);
                    String cPre = "" + s.charAt(0) + s.charAt(1);

                    if (!cPre.equals(pre)) {
                        if (wait.size() > 1) {
                            ArrayList<String> sort = numPartnerSort(num, wait);
                            for (int x = 0; x < sort.size() / 2; x++) {
                                wait.add(sort.get(x));
                                num.add(Integer.parseInt(sort.get(x + (sort.size() / 2))));
                            }
                        }
                        for (String e : wait)
                            System.out.println(e);
                        wait.clear();
                        num.clear();
                    }
                }
                wait.add(name);
                num.add(order);
            }

            // print whatever is left
            if (wait.size() > 1) {
                ArrayList<String> sorted = numPartnerSort(num, wait);
                for (int x = 0; x < sorted.size() / 2; x++) {
                    wait.add(sorted.get(x));
                    num.add(Integer.parseInt(sorted.get(x + (sorted.size() / 2))));
                }
            }
            for (String e : wait)
                System.out.println(e);
        }
        sc.close();
    }

    private static int howMany(TreeSet<String> names, String prefix) {
        int count = 1;
        for (String s : names)
            if (s.startsWith(prefix))
                count++;
        return count;
    }

    private static ArrayList<String> numPartnerSort(ArrayList<Integer> keyList, ArrayList<String> valueList) {
        ArrayList<Integer> sortedKey = new ArrayList<>();
        ArrayList<String> sortedVal = new ArrayList<>();

        while (keyList.size() != 0) {
            int min = keyList.get(0);
            int index = 0;
            for (int x = 0; x < keyList.size(); x++)
                if (keyList.get(x) < min) {
                    min = keyList.get(x);
                    index = x;
                }
            sortedKey.add(keyList.remove(index));
            sortedVal.add(valueList.remove(index));
        }

        for (int s : sortedKey)
            sortedVal.add("" + s);
        return sortedVal;
    }
}