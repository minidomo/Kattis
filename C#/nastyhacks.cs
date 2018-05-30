using System;

public class nastyhacks {
    public static void Main (string[] args) {
        int cases = int.Parse (Console.ReadLine ());
        while (cases-- > 0) {
            string[] line = Console.ReadLine ().Split (' ');
            int noads = int.Parse (line[0]);
            int yesads = int.Parse (line[1]);
            int adcost = int.Parse (line[2]);
            Console.WriteLine (yesads - adcost > noads ? "advertise" : yesads - adcost == noads ? "does not matter" : "do not advertise");
        }
    }
}