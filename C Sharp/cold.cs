using System;

public class cold {
    public static void Main (string[] args) {
        Console.ReadLine ();
        string[] nums = Console.ReadLine ().Split (' ');
        int count = 0;
        foreach (string s in nums)
            if (s[0] == '-')
                count++;
        Console.WriteLine (count);
    }
}