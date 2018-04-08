using System;

public class parking2 {
    public static void Main (string[] args) {
        int cases = int.Parse (Console.ReadLine ());
        while (cases-- > 0) {
            int length = int.Parse (Console.ReadLine ());
            int[] nums = new int[length];
            int i = 0;
            foreach (string s in Console.ReadLine ().Split (' '))
                nums[i++] = int.Parse (s);
            Array.Sort (nums);
            int total = nums[length - 1] - nums[0];
            for (int x = 0; x < length - 1; x++)
                total += nums[x + 1] - nums[x];
            Console.WriteLine (total);
        }
    }
}