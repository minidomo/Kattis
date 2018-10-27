import java.io.*;
import java.util.*;

public class falsesecurity {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
                "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };

        String line;
        while ((line = sc.readLine()) != null) {
            char[] arr = line.toCharArray();
            String morseCode = convertToMorse(morse, arr);
            String[] tokens = morseCode.split(" ");
            tokens[1] = new StringBuilder(tokens[1]).reverse().toString();
            String fixed = convertToString(morse, tokens);
            dc.write(fixed + "\n");
            dc.flush();
        }

        dc.close();
        sc.close();
    }

    private static String convertToString(String[] morse, String[] tokens) {
        String str = "";
        for (int x = 0; x < tokens[1].length(); x++) {
            int len = tokens[1].charAt(x) - '0';
            String find = tokens[0].substring(0, len);
            if (find.equals("..--"))
                str += "_";
            else if (find.equals(".-.-"))
                str += ",";
            else if (find.equals("---."))
                str += ".";
            else if (find.equals("----"))
                str += "?";
            else {
                for (int a = 0; a < morse.length; a++) {
                    if (morse[a].equals(find)) {
                        str += "" + (char) (a + 'A');
                        break;
                    }
                }
            }
            tokens[0] = tokens[0].substring(len);
        }
        return str;
    }

    private static String convertToMorse(String[] morse, char[] arr) {
        String str = "";
        String num = "";
        for (char c : arr) {
            if (c == '_') {
                str += "..--";
                num += 4;
            } else if (c == ',') {
                str += ".-.-";
                num += 4;
            } else if (c == '.') {
                str += "---.";
                num += 4;
            } else if (c == '?') {
                str += "----";
                num += 4;
            } else {
                str += morse[c - 'A'];
                num += morse[c - 'A'].length();
            }
        }
        return str + " " + num;
    }
}