
// https://open.kattis.com/problems/parsinghex
import java.util.Scanner;

public class parsinghex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            while (line.contains("0x") || line.contains("0X")) {
                int a = line.contains("0x") ? line.indexOf("0x") : 100;
                int b = line.contains("0X") ? line.indexOf("0X") : 100;
                int i = a < b ? a : b;
                StringBuilder temp = new StringBuilder(line);
                temp.setCharAt(i, ' ');
                line = temp.toString();
                String hex = "0x";
                char[] chars = line.toCharArray();
                for (i += 2; i < chars.length && ((chars[i] >= 'a' && chars[i] <= 'f')
                        || (chars[i] >= 'A' && chars[i] <= 'F') || (chars[i] >= '0' && chars[i] <= '9')); i++)
                    hex += chars[i];
                System.out.println(hex + " " + Long.decode(hex));
            }
        }
        sc.close();
    }
}
