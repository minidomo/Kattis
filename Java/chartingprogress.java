import java.io.*;
import java.util.*;

public class chartingprogress {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            ArrayList<String> list = new ArrayList<>();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.length() == 0)
                    break;
                list.add(line);
            }
            String[] arr = new String[list.get(0).length()];
            for (int c = 0; c < arr.length; c++) {
                arr[c] = "";
                for (int r = 0; r < list.size(); r++)
                    arr[c] += list.get(r).charAt(c);
            }
            Arrays.sort(arr, (a, b) -> {
                int c1 = a.indexOf('*');
                int c2 = b.indexOf('*');
                return c2 - c1;
            });
            String[] format = new String[list.size()];
            for (int r = 0; r < format.length; r++) {
                format[r] = "";
                for (int c = 0; c < arr.length; c++)
                    format[r] += arr[c].charAt(r);
            }
            for (String s : format)
                System.out.println(s);
            System.out.println();
        }
    }
}