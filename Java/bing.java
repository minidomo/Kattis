import java.io.*;
import java.util.*;

public class bing {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        Trie trie = new Trie();
        int n = Integer.parseInt(sc.readLine());
        while (n-- > 0)
            dc.write(trie.insert(sc.readLine()) + "\n");
        dc.close();
        sc.close();
    }
}

class Trie {
    private TrieNode root = new TrieNode();

    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int count = 0;
    }

    private int insert(TrieNode root, String s) {
        int i = s.charAt(0) - 'a';
        if (root.children[i] == null)
            root.children[i] = new TrieNode();
        root.count++;
        if (s.length() == 1)
            return root.children[i].count++;
        return insert(root.children[i], s.substring(1));
    }

    public int insert(String s) {
        return insert(root, s);
    }
}