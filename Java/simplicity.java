import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class simplicity {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<Character, Integer> chars = new HashMap<>();

        char[] arr = sc.readLine().toCharArray();
        Arrays.sort(arr);
        String word = new String(arr);
        for (int x = 0; x < word.length();) {
            int nextIndex = word.lastIndexOf(word.charAt(x)) + 1;
            chars.put(word.charAt(x), nextIndex >= word.length() ? word.length() - x : nextIndex - x);
            x = nextIndex;
        }

        int count = 0;
        while (chars.size() > 2) {
            int least = 101;
            char c = '1';
            for (Map.Entry<Character, Integer> a : chars.entrySet()) {
                if (a.getValue() < least) {
                    c = a.getKey();
                    least = a.getValue();
                }
            }
            count += least;
            chars.remove(c);
        }
        dc.write(count + "\n");

        dc.close();
        sc.close();
    }
}