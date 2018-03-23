
// https://open.kattis.com/problems/aboveaverage
import java.util.Scanner;

public class aboveaverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();
        while (cases-- > 0) {
            double students = sc.nextDouble();
            int[] grades = new int[(int) students];
            double sum = 0;
            for (int x = 0; x < students; x++) {
                grades[x] = sc.nextInt();
                sum += grades[x];
            }
            sum /= students;
            double count = 0;
            for (int s : grades)
                if (s > sum)
                    count++;
            System.out.printf("%.3f%s", ((count / students) * 100), "%\n");
        }
        sc.close();
    }
}
