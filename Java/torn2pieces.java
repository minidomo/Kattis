import java.io.*;
import java.util.*;

public class torn2pieces {
    private static HashMap<String, HashSet<String>> nodes = new HashMap<>();
    private static HashMap<String, Boolean> visit = new HashMap<>();
    private static HashMap<String, String> parent = new HashMap<>();
    private static String start;

    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        int n = Integer.parseInt(sc.readLine());
        while (n-- > 0) {
            String[] arr = sc.readLine().split(" ");
            if (!nodes.containsKey(arr[0])) {
                nodes.put(arr[0], new HashSet<>());
                visit.put(arr[0], false);
                parent.put(arr[0], "");
            }
            for (int x = 1; x < arr.length; x++) {
                if (!nodes.containsKey(arr[x])) {
                    nodes.put(arr[x], new HashSet<>());
                    visit.put(arr[x], false);
                    parent.put(arr[x], "");
                }
                nodes.get(arr[x]).add(arr[0]);
                nodes.get(arr[0]).add(arr[x]);
            }
        }
        String[] arr = sc.readLine().split(" ");
        start = arr[0];
        boolean found = dfs(arr[1]);
        if (!found)
            dc.write("no route found");
        else {
            String cur = start;
            String path = "";
            while (cur.length() != 0) {
                path += cur + " ";
                cur = parent.get(cur);
            }
            dc.write(path);
        }
        dc.close();
        sc.close();
    }

    private static boolean dfs(String node) {
        if (!nodes.containsKey(node))
            return false;
        visit.put(node, true);
        if (node.equals(start))
            return true;
        for (String a : nodes.get(node)) {
            if (visit.get(a))
                continue;
            parent.put(a, node);
            if (dfs(a))
                return true;
        }
        return false;
    }
}
