
// https://open.kattis.com/problems/estimatingtheareaofacircle
import java.util.Scanner;

public class estimatingtheareaofacircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            double radius = sc.nextDouble();
            double points = sc.nextDouble();
            double pointsInCircle = sc.nextDouble();
            if (radius == 0 && points == 0 && pointsInCircle == 0)
                break;
            String areaLine = Double.toString(Math.pow(radius, 2) * Math.PI);
            String area = "";
            for (int x = 0, length = areaLine.length() > 11 ? 11 : areaLine.length(); x < length; x++)
                area += areaLine.charAt(x);

            String estimateLine = Double.toString((pointsInCircle / points) * Math.pow(radius * 2, 2));
            String estimate = "";
            if (Double.parseDouble(estimateLine) % 1 == 0)
                estimate += (int) Double.parseDouble(estimateLine);
            else
                for (int x = 0, length = estimateLine.length() > 11 ? 11 : estimateLine.length(); x < length; x++)
                    estimate += estimateLine.charAt(x);
            System.out.println(area + " " + estimate);
        }
        sc.close();
    }
}