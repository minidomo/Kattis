
// https://open.kattis.com/problems/tri
import java.util.Scanner;

public class tri {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int fnum = sc.nextInt();
        int snum = sc.nextInt();
        int tnum = sc.nextInt();
        boolean division = fnum / snum == tnum || snum / tnum == fnum ? true : false;
        boolean multiply = fnum * snum == tnum || snum * tnum == fnum ? true : false;
        boolean add = fnum + snum == tnum || snum + tnum == fnum ? true : false;
        if (division)
            System.out.println(fnum / snum == tnum ? fnum + "/" + snum + "=" + tnum : fnum + "=" + snum + "/" + tnum);
        else if (multiply)
            System.out.println(fnum * snum == tnum ? fnum + "*" + snum + "=" + tnum : fnum + "=" + snum + "*" + tnum);
        else if (add)
            System.out.println(fnum + snum == tnum ? fnum + "+" + snum + "=" + tnum : fnum + "=" + snum + "+" + tnum);
        else
            System.out.println(fnum - snum == tnum ? fnum + "-" + snum + "=" + tnum : fnum + "=" + snum + "-" + tnum);
        sc.close();
    }
}