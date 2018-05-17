
// https://open.kattis.com/problems/skener
import java.util.Scanner;

public class skener {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int row = sc.nextInt();
        sc.nextInt();
        int rowTimes = sc.nextInt();
        int colTimes = sc.nextInt();
        sc.nextLine();

        String[] article = new String[row * rowTimes];

        int index1 = 0;
        for (int x = 0; x < row; x++) {
            String line = sc.nextLine();
            for (int z = 0; z < rowTimes; z++) {
                article[index1] = line;
                index1++;
            }
        }

        int index2 = 0;
        for (int x = 0; x < article.length; x++) {
            String line = article[index2];
            article[index2] = "";
            for (int c = 0; c < line.length(); c++) {
                for (int z = 0; z < colTimes; z++)
                    article[index2] += line.charAt(c);
            }
            index2++;
        }

        for (String s : article)
            System.out.println(s);
        sc.close();
    }
}