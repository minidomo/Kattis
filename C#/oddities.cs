using System;

public class oddities {
    public static void Main (string[] args) {
        int cases = int.Parse (Console.ReadLine ());
        while (cases-- > 0) {
            int num = int.Parse (Console.ReadLine ());
            Console.WriteLine ((Math.Abs (num) & 1) == 0 ? num + " is even" : num + " is odd");
        }
    }
}