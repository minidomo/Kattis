using System;

public class carrots {
    public static void Main (string[] args) {
        string[] nums = Console.ReadLine ().Split (' ');
        int num = int.Parse (nums[0]);
        while (num-- > 0)
            Console.ReadLine ();
        Console.WriteLine (nums[1]);
    }
}