
// https://open.kattis.com/problems/numberfun
import java.util.Scanner;

public class numberfun {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int cases = sc.nextInt();
        while(cases-- > 0) {
            double fnum = sc.nextDouble();
            double snum = sc.nextDouble();
            double tnum = sc.nextDouble();
            System.out.println(fnum + snum == tnum || Math.abs(fnum - snum) == tnum || fnum * snum == tnum || fnum / snum == tnum || snum / fnum == tnum ? "Possible" : "Impossible");
        }
    }
}
