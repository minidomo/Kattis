
// https://open.kattis.com/problems/onechicken
import java.util.Scanner;

public class onechicken {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int people = sc.nextInt();
        int chicken = sc.nextInt();

        int p = chicken - people;
        int q = people - chicken;

        System.out.println(people < chicken
                ? p == 1 ? "Dr. Chaz will have " + p + " piece of chicken left over!"
                        : "Dr. Chaz will have " + p + " pieces of chicken left over!"
                : q == 1 ? "Dr. Chaz needs " + q + " more piece of chicken!"
                        : "Dr. Chaz needs " + q + " more pieces of chicken!");

        sc.close();
    }
}