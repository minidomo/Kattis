using System;

public class sibice {
    public static void Main (string[] args) {
        string[] nums = Console.ReadLine ().Split (' ');
        int cases = int.Parse (nums[0]);
        double hypot = Math.Sqrt (Math.Pow (int.Parse (nums[1]), 2) + Math.Pow (int.Parse (nums[2]), 2));
        while (cases-- > 0)
            Console.WriteLine (int.Parse (Console.ReadLine ()) <= hypot ? "DA" : "NE");
    }
}