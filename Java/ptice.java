
// https://open.kattis.com/problems/ptice
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;

public class ptice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] adrianAnswers = {'A', 'B', 'C'};
        char[] brunoAnswers = {'B', 'A', 'B', 'C'};
        char[] goranAnswers = {'C', 'C', 'A', 'A', 'B', 'B'};

        int questions = sc.nextInt();
        sc.nextLine();
        String correctAnswers = sc.nextLine();

        TreeMap<String, Integer> scores = new TreeMap<>();

        int aCount = 0;
        int bCount = 0;
        int gCount = 0;
        for (int x = 0, a = 0, b = 0, g = 0; x < questions; x++, a++, b++, g++) {
            if (correctAnswers.charAt(x) == adrianAnswers[a])
                scores.put("Adrian", ++aCount);

            if (correctAnswers.charAt(x) == brunoAnswers[b])
                scores.put("Bruno", ++bCount);

            if (correctAnswers.charAt(x) == goranAnswers[g])
                scores.put("Goran", ++gCount);

            if (a == adrianAnswers.length - 1)
                a = -1;
            if (b == brunoAnswers.length - 1)
                b = -1;
            if (g == goranAnswers.length - 1)
                g = -1;
        }

        int highest = 0;
        for (Map.Entry<String, Integer> s : scores.entrySet())
            if (s.getValue() > highest)
                highest = s.getValue();

        System.out.println(highest);
        for (Map.Entry<String, Integer> s : scores.entrySet())
            if (s.getValue() == highest)
                System.out.println(s.getKey());
        sc.close();
    }
}