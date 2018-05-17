
// https://open.kattis.com/problems/easiest
import java.util.Scanner;

public class easiest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean isZero = false;
        while (!isZero) {
            String n = sc.nextLine();
            if (n.equals("0"))
                isZero = true;
            else {
                char[] digitsOfN = n.toCharArray();
                int sumOfDigitsN = 0;

                for (char c : digitsOfN)
                    sumOfDigitsN += Integer.parseInt(Character.toString(c));

                for (int x = 11; x > 0; x++) {
                    int newNum = x * Integer.parseInt(n);
                    int tempSumDigits = 0;
                    char[] temp = Integer.toString(newNum).toCharArray();

                    for (char c : temp)
                        tempSumDigits += Integer.parseInt(Character.toString(c));

                    if (tempSumDigits == sumOfDigitsN) {
                        System.out.println(x);
                        break;
                    }
                }
            }
        }
        sc.close();
    }
}