using System;

public class oddgnome {
    public static void Main (string[] args) {
        int cases = int.Parse (Console.ReadLine ());
        while (cases-- > 0) {
            string[] line = Console.ReadLine ().Split (' ');
            int[] nums = new int[line.Length - 2];
            for (int x = 0; x < nums.Length; x++)
                nums[x] = int.Parse (line[x + 1]);
            for (int x = 0; x < line.Length - 1; x++)
                if (nums[x] != nums[x + 1] - 1) {
                    Console.WriteLine (x + 2);
                    break;
                }
        }
    }
}