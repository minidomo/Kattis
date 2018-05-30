using System;
using System.Linq;

public class everywhere {
    public static void Main (string[] args) {
        int cases = int.Parse (Console.ReadLine ());
        while (cases-- > 0) {
            int num = int.Parse (Console.ReadLine ());
            string[] cities = new string[num];
            for (int x = 0; x < num; x++)
                cities[x] = Console.ReadLine ();
            Console.WriteLine (cities.Distinct ().Count ());
        }
    }
}