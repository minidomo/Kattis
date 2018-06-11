using System;

public class simpleaddition {
    public static void Main (string[] args) {
        string first = Console.ReadLine ();
        string second = Console.ReadLine ();
        int carry = 0;
        int a = first.Length - 1, b = second.Length - 1;
        string sum = "";
        for (; a >= 0 && b >= 0; a--, b--) {
            int num = int.Parse (first[a] + "") + int.Parse (second[b] + "") + carry;
            sum = num % 10 + sum;
            carry = num / 10;
        }
        for (; a >= 0; a--) {
            int num = int.Parse (first[a] + "") + carry;
            sum = num % 10 + sum;
            carry = num / 10;
        }
        for (; b >= 0; b--) {
            int num = int.Parse (second[b] + "") + carry;
            sum = num % 10 + sum;
            carry = num / 10;
        }
        if (carry != 0)
            sum = carry + sum;
        Console.WriteLine (sum);
    }
}