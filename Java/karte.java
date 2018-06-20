
// https://open.kattis.com/problems/karte
import java.util.Scanner;

public class karte {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String cardLabels = sc.nextLine();
        String[] cards = new String[cardLabels.length()/3];
        int p = 13, k = 13, h = 13, t = 13;
        int index = 0;
        boolean broken = false;
        for (int x = 0; x < cards.length; x++) {
            String temp = "";
            int doThree = 3;
            while (doThree-- > 0) {
                temp += cardLabels.charAt(index);
                index++;
            }
            for (String s : cards)
                if (temp.equals(s))
                    broken = true;
            cards[x] = temp;
        }
        if (broken)
            System.out.println("GRESKA");
        else {
            for (String s : cards)
                if (s.charAt(0) == 'P')
                    p--;
                else if (s.charAt(0) == 'K')
                    k--;
                else if (s.charAt(0) == 'H')
                    h--;
                else
                    t--;
            System.out.println(p + " " + k + " " + h + " " + t);
        }
        sc.close();
    }
}