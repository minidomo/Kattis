
// https://open.kattis.com/problems/modulo
import java.util.HashSet;
import java.util.Scanner;

public class modulo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Integer> modulo = new HashSet<>();

        for (int x = 0; x < 10; x++)
            modulo.add(sc.nextInt() % 42);
        System.out.println(modulo.size());
        sc.close();
    }
}