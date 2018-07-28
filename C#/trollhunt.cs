using System;
using System.Linq;

public class trollhunt {
    public static void Main (string[] args) {
        int[] nums = Console.ReadLine ().Split ().Select (s => int.Parse (s)).ToArray ();
        Console.WriteLine (Math.Ceiling ((nums[0] - 1) / (double) (nums[1] / nums[2])));
    }
}