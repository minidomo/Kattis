using System;

public class stararrangements {
    public static void Main (string[] args) {
        int stars = int.Parse (Console.ReadLine ());
        Console.WriteLine (stars + ":");
        for (int x = 2; x <= (stars / 2) + 1; x++) {
            if (stars % (x + (x - 1)) == x || stars % (x + (x - 1)) == 0)
                Console.WriteLine (x + "," + (x - 1));
            if (stars % x == 0)
                Console.WriteLine (x + "," + x);
        }
    }
}