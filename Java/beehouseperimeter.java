import java.io.*;
import java.util.*;

public class beehouseperimeter {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        int r = Integer.parseInt(sc.readLine().split(" ")[0]);
        HexGrid grid = new HexGrid(r);
        for (String s : sc.readLine().split(" "))
            grid.mark(Integer.parseInt(s));
        grid.calcPerimeter();
        dc.write(grid.getPerimeter() + "\n");

        dc.close();
        sc.close();
    }
}

class HexGrid {
    private int[][] grid;
    private boolean[][] visited;
    private boolean[] markedGrid;
    private int size;
    private int perimeter;

    public HexGrid(int size) {
        this.size = size;
        int dubsize = size + size;
        grid = new int[dubsize + 1][dubsize + 1];
        visited = new boolean[dubsize + 1][dubsize + 1];
        markedGrid = new boolean[size * size * size - (size - 1) * (size - 1) * (size - 1) + 1];
        boolean reverse = false;
        for (int r = 1, num = 1, colSize = size; r < dubsize; r++) {
            for (int c = 1; c <= colSize; c++)
                grid[r][c] = num++;
            if (colSize == dubsize - 1)
                reverse = true;
            colSize = colSize + (reverse ? -1 : 1);
        }
    }

    public int getPerimeter() {
        return perimeter;
    }

    public void mark(int num) {
        markedGrid[num] = true;
    }

    public void calcPerimeter() {
        calcPerimeter(0, 0);
    }

    private void calcPerimeter(int row, int col) {
        if (row < 0 || row == grid.length || col < 0 || col == grid.length)
            return;
        if (visited[row][col])
            return;
        if (markedGrid[grid[row][col]]) {
            perimeter++;
            return;
        }
        visited[row][col] = true;
        calcPerimeter(row, col - 1); // left
        calcPerimeter(row, col + 1); // right
        if (row < size) {
            calcPerimeter(row - 1, col - 1); // topleft
            calcPerimeter(row - 1, col); // topright
            calcPerimeter(row + 1, col); // botleft
            calcPerimeter(row + 1, col + 1); // botright
        } else if (row > size) {
            calcPerimeter(row - 1, col); // topleft
            calcPerimeter(row - 1, col + 1); // topright
            calcPerimeter(row + 1, col - 1); // botleft
            calcPerimeter(row + 1, col); // botright
        } else {
            calcPerimeter(row - 1, col - 1); // topleft
            calcPerimeter(row - 1, col); // topright
            calcPerimeter(row + 1, col - 1); // botleft
            calcPerimeter(row + 1, col); // botright
        }
    }
}