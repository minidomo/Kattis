import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class wordsfornumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        while (sc.ready()) {
            int x = 0;
            for (String s : sc.readLine().split(" ")) {
                if (Character.isDigit(s.charAt(0))) {
                    String word = getWord(Integer.parseInt(s), "");
                    if (x == 0)
                        word = word.substring(0, 1).toUpperCase() + word.substring(1);
                    dc.write(word + " ");
                } else
                    dc.write(s + " ");
                x++;
            }
            dc.write("\n");
        }

        dc.close();
        sc.close();
    }

    private static String getWord(int num, String s) {
        if (num >= 20 && num < 30)
            return num == 20 ? "twenty" : getWord(num % 10, "twenty-");
        if (num >= 30 && num < 40)
            return num == 30 ? "thirty" : getWord(num % 10, "thirty-");
        if (num >= 40 && num < 50)
            return num == 40 ? "forty" : getWord(num % 10, "forty-");
        if (num >= 50 && num < 60)
            return num == 50 ? "fifty" : getWord(num % 10, "fifty-");
        if (num >= 60 && num < 70)
            return num == 60 ? "sixty" : getWord(num % 10, "sixty-");
        if (num >= 70 && num < 80)
            return num == 70 ? "seventy" : getWord(num % 10, "seventy-");
        if (num >= 80 && num < 90)
            return num == 80 ? "eighty" : getWord(num % 10, "eighty-");
        if (num >= 90)
            return num == 90 ? "ninety" : getWord(num % 10, "ninety-");
        if (num == 10)
            return "ten";
        if (num == 11)
            return "eleven";
        if (num == 12)
            return "twelve";
        if (num == 13)
            return "thirteen";
        if (num == 14)
            return "fourteen";
        if (num == 15)
            return "fifteen";
        if (num == 16)
            return "sixteen";
        if (num == 17)
            return "seventeen";
        if (num == 18)
            return "eighteen";
        if (num == 19)
            return "nineteen";
        if (num == 0)
            return "zero";
        if (num == 1)
            return s + "one";
        if (num == 2)
            return s + "two";
        if (num == 3)
            return s + "three";
        if (num == 4)
            return s + "four";
        if (num == 5)
            return s + "five";
        if (num == 6)
            return s + "six";
        if (num == 7)
            return s + "seven";
        if (num == 8)
            return s + "eight";
        if (num == 9)
            return s + "nine";
        return "";
    }
}