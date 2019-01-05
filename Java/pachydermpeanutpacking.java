import java.io.*;
import java.util.*;

public class pachydermpeanutpacking {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        for (;;) {
            int num = Integer.parseInt(sc.readLine());
            if (num == 0)
                break;
            Box[] boxes = new Box[num];
            for (int x = 0; x < num; x++)
                boxes[x] = new Box(sc.readLine().split(" "));
            int nuts = Integer.parseInt(sc.readLine());
            while (nuts-- > 0) {
                String[] line = sc.readLine().split(" ");
                double x = Double.parseDouble(line[0]);
                double y = Double.parseDouble(line[1]);
                boolean found = false;
                for (Box a : boxes)
                    if (a.isInside(x, y)) {
                        dc.write(line[2] + " " + (line[2].equals(a.size) ? "correct" : a.size) + "\n");
                        found = true;
                        break;
                    }
                if (!found)
                    dc.write(line[2] + " floor\n");
                dc.flush();
            }
            dc.write("\n");
        }
        dc.close();
        sc.close();
    }
}

class Box {
    public double x1, y1, x2, y2;
    public String size;

    public Box(String[] arr) {
        x1 = Double.parseDouble(arr[0]);
        y1 = Double.parseDouble(arr[1]);
        x2 = Double.parseDouble(arr[2]);
        y2 = Double.parseDouble(arr[3]);
        size = arr[4];
    }

    public boolean isInside(double x, double y) {
        return x >= x1 && x <= x2 && y >= y1 && y <= y2;
    }
}