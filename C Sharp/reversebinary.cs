using System;

public class reversebinary {
    public static void Main (string[] args) {
        string binary = Convert.ToString (int.Parse (Console.ReadLine ()), 2);
        string flip = "";
        for (int x = binary.Length - 1; x >= 0; x--)
            flip += binary[x];
        Console.WriteLine (Convert.ToInt32 (flip, 2));
    }
}