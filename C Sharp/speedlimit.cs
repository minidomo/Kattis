using System;

public class speedlimit {
    public static void Main (string[] args) {
        for (;;) {
            int cases = int.Parse (Console.ReadLine ());
            if (cases == -1)
                break;
            int[] nums = new int[cases * 2];
            for (int x = 0; x < nums.Length; x += 2) {
                string line = Console.ReadLine ();
                int space = line.IndexOf (' ');
                nums[x] = int.Parse (line.Substring (0, space));
                nums[x + 1] = int.Parse (line.Substring (space + 1));
            }
            int distance = nums[0] * nums[1];
            for (int x = 2; x < nums.Length; x += 2)
                distance += nums[x] * (nums[x + 1] - nums[x - 1]);
            Console.WriteLine (distance + " miles");
        }
    }
}