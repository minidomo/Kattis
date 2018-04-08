using System;

public class zanzibar {
    public static void Main (string[] args) {
        int cases = int.Parse (Console.ReadLine ());
        while (cases-- > 0) {
            string[] nums = Console.ReadLine ().Split (' ');
            int notBorn = 0;
            for (int x = 0; x < nums.Length - 2; x++) {
                int yearLater = int.Parse (nums[x + 1]);
                int currentYear = int.Parse (nums[x]) * 2;
                if (yearLater > currentYear)
                    notBorn += yearLater - currentYear;
            }
            Console.WriteLine (notBorn);
        }
    }
}