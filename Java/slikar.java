import java.io.*;
import java.util.*;

public class slikar {

    private static char[][] map;
    private static boolean[][] visit;
    private static Queue<Pair> paths;

    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        int rows = Integer.parseInt(sc.readLine().split(" ")[0]);
        map = new char[rows][];
        visit = new boolean[rows][];
        paths = new LinkedList<>();
        Queue<Pair> floods = new LinkedList<>();
        Pair end = null;
        for (int r = 0; r < rows; r++) {
            map[r] = sc.readLine().toCharArray();
            visit[r] = new boolean[map[r].length];
            for (int c = 0; c < map[r].length; c++)
                if (map[r][c] == 'D')
                    end = new Pair(r, c);
                else if (map[r][c] == 'S') {
                    map[r][c] = '.';
                    visit[r][c] = true;
                    paths.add(new Pair(r, c, 0));
                } else if (map[r][c] == '*')
                    floods.add(new Pair(r, c));
        }

        int count = Integer.MAX_VALUE;
        bfs: {
            while (paths.size() != 0) {
                int size = paths.size();
                while (size-- > 0) {
                    Pair cur = paths.poll();
                    Pair temp = null;
                    if (validLoc(cur.r - 1, cur.c, 'S')) {
                        temp = new Pair(cur.r - 1, cur.c, cur.count + 1);
                        paths.add(temp);
                        visit[temp.r][temp.c] = true;
                        if (temp.r == end.r && temp.c == end.c) {
                            count = temp.count;
                            break bfs;
                        }
                    }
                    if (validLoc(cur.r + 1, cur.c, 'S')) {
                        temp = new Pair(cur.r + 1, cur.c, cur.count + 1);
                        paths.add(temp);
                        visit[temp.r][temp.c] = true;
                        if (temp.r == end.r && temp.c == end.c) {
                            count = temp.count;
                            break bfs;
                        }
                    }
                    if (validLoc(cur.r, cur.c - 1, 'S')) {
                        temp = new Pair(cur.r, cur.c - 1, cur.count + 1);
                        paths.add(temp);
                        visit[temp.r][temp.c] = true;
                        if (temp.r == end.r && temp.c == end.c) {
                            count = temp.count;
                            break bfs;
                        }
                    }
                    if (validLoc(cur.r, cur.c + 1, 'S')) {
                        temp = new Pair(cur.r, cur.c + 1, cur.count + 1);
                        paths.add(temp);
                        visit[temp.r][temp.c] = true;
                        if (temp.r == end.r && temp.c == end.c) {
                            count = temp.count;
                            break bfs;
                        }
                    }
                }

                size = floods.size();
                while (size-- > 0) {
                    Pair field = floods.poll();
                    if (validLoc(field.r - 1, field.c, '*')) {
                        map[field.r - 1][field.c] = '*';
                        floods.add(new Pair(field.r - 1, field.c));
                    }
                    if (validLoc(field.r + 1, field.c, '*')) {
                        floods.add(new Pair(field.r + 1, field.c));
                        map[field.r + 1][field.c] = '*';
                    }
                    if (validLoc(field.r, field.c - 1, '*')) {
                        floods.add(new Pair(field.r, field.c - 1));
                        map[field.r][field.c - 1] = '*';
                    }
                    if (validLoc(field.r, field.c + 1, '*')) {
                        floods.add(new Pair(field.r, field.c + 1));
                        map[field.r][field.c + 1] = '*';
                    }
                }
            }
        }
        dc.write(count == Integer.MAX_VALUE ? "KAKTUS\n" : count + "\n");

        dc.close();
        sc.close();
    }

    private static boolean validLoc(int r, int c, char a) {
        boolean inRange = r >= 0 && r < map.length && c >= 0 && c < map[0].length;
        if (!inRange || a == '*' && map[r][c] == '*' || a == 'S' && visit[r][c])
            return false;
        if (a == '*' && map[r][c] == '.')
            for (Pair p : paths)
                if (p.r == r && p.c == c)
                    return paths.remove(p);
        return map[r][c] == '.' || a == 'S' && map[r][c] == 'D';
    }
}

class Pair {
    public int r, c, count;

    public Pair(int r, int c, int count) {
        this.r = r;
        this.c = c;
        this.count = count;
    }

    public Pair(int r, int c) {
        this.r = r;
        this.c = c;
        count = 0;
    }

    public String toString() {
        return "(" + r + ", " + c + ")";
    }
}