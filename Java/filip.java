
// https://open.kattis.com/problems/filip
import java.util.Scanner;

public class filip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String temp1 = new StringBuffer(sc.next()).reverse().toString();
        String temp2 = new StringBuffer(sc.next()).reverse().toString();
        int fnum = Integer.parseInt(temp1);
        int snum = Integer.parseInt(temp2);
        System.out.println(fnum > snum ? fnum : snum);
        sc.close();
    }
}