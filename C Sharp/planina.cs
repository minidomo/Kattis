using System;

public class planina {
    public static void Main (string[] args) {
        int cases = int.Parse (Console.ReadLine ());
        int points = 2;
        while (cases-- > 0)
            points += points - 1;
        Console.WriteLine ((int) Math.Pow (points, 2));
    }
}