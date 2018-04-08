using System;

public class tarifa {
    public static void Main (string[] args) {
        int mb = int.Parse (Console.ReadLine ());
        int months = int.Parse (Console.ReadLine ());
        int spare = 0;
        while (months-- > 0)
            spare += mb - int.Parse (Console.ReadLine ());
        Console.WriteLine (spare + mb);
    }
}