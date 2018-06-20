
// https://open.kattis.com/problems/zanzibar
import java.util.ArrayList;
import java.util.Scanner;

public class zanzibar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();
        while (cases-- > 0) {
            ArrayList<Integer> numOfTurtles = new ArrayList<>();
            while (true) {
                int turtle = sc.nextInt();
                if (turtle == 0)
                    break;
                numOfTurtles.add(turtle);
            }
            int imports = 0;
            for (int x = 0; x < numOfTurtles.size() - 1; x++)
                if (numOfTurtles.get(x) * 2 < numOfTurtles.get(x + 1))
                    imports += (numOfTurtles.get(x + 1) - numOfTurtles.get(x) * 2);
            System.out.println(imports);
        }
        sc.close();
    }
}