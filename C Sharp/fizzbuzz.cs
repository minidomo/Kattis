using System;

public class fizzbuzz {
    public static void Main (string[] args) {
        string[] line = Console.ReadLine ().Split (' ');
        int x = int.Parse (line[0]);
        int y = int.Parse (line[1]);
        int n = int.Parse (line[2]);
        for (int a = 1; a <= n; a++)
            Console.WriteLine (a % x == 0 && a % y == 0 ? "FizzBuzz" : a % x == 0 ? "Fizz" : a % y == 0 ? "Buzz" : a + "");
    }
}