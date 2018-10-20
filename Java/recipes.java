import java.io.*;
import java.util.*;

public class recipes {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        int cases = Integer.parseInt(sc.readLine());
        for (int casesNum = 1; casesNum <= cases; casesNum++) {
            String[] tokens = sc.readLine().split(" ");
            int recipes = Integer.parseInt(tokens[0]);
            double scaleFactor = Double.parseDouble(tokens[2]) / Double.parseDouble(tokens[1]), main = 0;
            Ingredient[] arr = new Ingredient[recipes];
            for (int x = 0; x < recipes; x++) {
                arr[x] = new Ingredient(sc.readLine());
                if (arr[x].percent == 1)
                    main = scaleFactor * arr[x].weight;
            }
            dc.write("Recipe # " + casesNum + "\n");
            for (Ingredient a : arr)
                dc.write(String.format("%s %.1f\n", a.name, a.percent * main));
            dc.write("----------------------------------------\n");
        }

        dc.close();
        sc.close();
    }

    private static class Ingredient {
        private String name;
        private double weight, percent;

        public Ingredient(String s) {
            String[] arr = s.split(" ");
            name = arr[0];
            weight = Double.parseDouble(arr[1]);
            percent = Double.parseDouble(arr[2]) / 100;
        }
    }
}