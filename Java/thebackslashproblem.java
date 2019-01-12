import java.util.*;

public class thebackslashproblem {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int n = sc.nextInt();
            sc.nextLine();
            String line = sc.nextLine();
            while (n-- > 0) {
                line = line.replace("\\", "\\\\");
                line = line.replace("!", "\\!");
                line = line.replace("\"", "\\\"");
                line = line.replace("#", "\\#");
                line = line.replace("$", "\\$");
                line = line.replace("%", "\\%");
                line = line.replace("&", "\\&");
                line = line.replace("'", "\\'");
                line = line.replace("(", "\\(");
                line = line.replace(")", "\\)");
                line = line.replace("*", "\\*");
                line = line.replace("[", "\\[");
                line = line.replace("]", "\\]");
            }
            System.out.println(line);
        }
        sc.close();
    }
}