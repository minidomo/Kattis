
// https://open.kattis.com/problems/bela
import java.util.Scanner;

public class bela {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt() * 4;
        String dominantSuit = sc.next();
        int points = 0;
        sc.nextLine();
        while (cases-- > 0) {
            String card = sc.nextLine();
            if (card.contains("A"))
                points += 11;
            else if (card.contains("K"))
                points += 4;
            else if (card.contains("Q"))
                points += 3;
            else if (card.contains("T"))
                points += 10;
            else if (card.contains("9" + dominantSuit))
                points += 14;
            else if (card.contains("J")) {
                if (card.contains(dominantSuit))
                    points += 20;
                else
                    points += 2;
            }

        }
        System.out.println(points);
        sc.close();
    }
}