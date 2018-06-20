
// https://open.kattis.com/problems/acm
import java.util.ArrayList;
import java.util.Scanner;

public class acm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> times = new ArrayList<>();
        ArrayList<String> problems = new ArrayList<>();
        ArrayList<String> states = new ArrayList<>();
        while (true) {
            int min = sc.nextInt();
            if (min == -1)
                break;
            times.add(min);
            problems.add(sc.next());
            states.add(sc.next());
        }

        int size = times.size();
        int correct = 0;
        int totaltime = 0;
        ArrayList<Integer> indexes = new ArrayList<>();

        for (int x = 0; x < size; x++)
            if (states.get(x).equals("right")) {
                correct++;
                totaltime += times.get(x);
                indexes.add(x);
            }

        for (int s : indexes) {
            int count = 0;
            String answer = problems.get(s);
            for (String x : problems)
                if (x.equals(answer))
                    count++;
            count--;
            totaltime += count * 20;
        }
        System.out.println(correct + " " + totaltime);

        sc.close();
    }
}