import java.io.*;
import java.util.*;

public class thegrandadventure {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int[] map = new int[200];
        map['b'] = '$';
        map['t'] = '|';
        map['j'] = '*';
        int n = sc.nextInt();
        while (n-- > 0) {
            char[] arr = sc.next().replace(".", "").toCharArray();
            Stack<Character> s = new Stack<>();
            boolean fail = false;
            for (int x = 0; x < arr.length; x++)
                if (map[arr[x]] > 0) {
                    if (s.isEmpty() || map[arr[x]] != s.peek()) {
                        System.out.println("NO");
                        fail = true;
                        break;
                    } else
                        s.pop();
                } else
                    s.push(arr[x]);
            if (!fail)
                System.out.println(s.isEmpty() ? "YES" : "NO");
        }
    }
}