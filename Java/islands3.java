import java.io.*;
import java.util.*;

public class islands3 {

    private static HashSet<Point> points;
    private static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] tokens = sc.readLine().split(" ");
        int rows = Integer.parseInt(tokens[0]);
        int cols = Integer.parseInt(tokens[1]);
        char[][] map = new char[rows][cols];
        points = new HashSet<>();
        Point first = null;
        for (int r = 0, c = 0; r < rows; r++, c = 0) {
            for (char a : sc.readLine().toCharArray()) {
                if (a == 'L') {
                    if (first == null)
                        first = new Point(r, c);
                    points.add(new Point(r, c));
                }
                map[r][c++] = a;
            }
        }

        if (points.isEmpty()) {
            dc.write("0\n");
        } else {
            for (Point p : points) {
                transform(map, p.r - 1, p.c);
                transform(map, p.r + 1, p.c);
                transform(map, p.r, p.c - 1);
                transform(map, p.r, p.c + 1);
            }

            int count = 0;
            visit = new boolean[rows][cols];
            Iterator<Point> it = points.iterator();
            while (it.hasNext()) {
                Point p = it.next();
                count++;
                count(map, p.r, p.c);
                it = points.iterator();
            }
            dc.write(count + "\n");
        }

        dc.close();
        sc.close();
    }

    private static void count(char[][] map, int row, int col) {
        if (row == map.length || row == -1 || col == map[row].length || col == -1)
            return;
        if (map[row][col] == 'L' && !visit[row][col]) {
            visit[row][col] = true;
            contains(new Point(row, col));
            count(map, row - 1, col);
            count(map, row + 1, col);
            count(map, row, col - 1);
            count(map, row, col + 1);
        }
    }

    private static void transform(char[][] map, int row, int col) {
        if (row == map.length || row == -1 || col == map[row].length || col == -1)
            return;
        if (map[row][col] == 'C') {
            map[row][col] = 'L';
            transform(map, row - 1, col);
            transform(map, row + 1, col);
            transform(map, row, col - 1);
            transform(map, row, col + 1);
        }
    }

    private static void contains(Point a) {
        for (Point p : points)
            if (a.equals(p)) {
                points.remove(p);
                return;
            }
    }

    private static class Point {
        private int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public boolean equals(Point a) {
            return r == a.r && c == a.c;
        }
    }
}