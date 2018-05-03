using System;

public class soylent {
    public static void Main (string[] args) {
        int cases = int.Parse (Console.ReadLine ());
        while (cases-- > 0) {
            int cal = int.Parse (Console.ReadLine ());
            Console.WriteLine (cal % 400 == 0 ? cal / 400 : (cal / 400) + 1);
        }
    }
}