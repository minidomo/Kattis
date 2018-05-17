using System;

public class numberfun {
    public static void Main (string[] args) {
        int cases = int.Parse (Console.ReadLine ());
        while (cases-- > 0) {
            string[] line = Console.ReadLine ().Split (' ');
            double first = double.Parse (line[0]);
            double sec = double.Parse (line[1]);
            double thi = double.Parse (line[2]);
            if (first + sec == thi || first == sec + thi)
                Console.WriteLine ("Possible");
            else if (first - sec == thi || first == sec - thi)
                Console.WriteLine ("Possible");
            else if (first * sec == thi || first == sec * thi)
                Console.WriteLine ("Possible");
            else if (first / sec == thi || first == sec / thi)
                Console.WriteLine ("Possible");
            else
                Console.WriteLine ("Impossible");
        }
    }
}