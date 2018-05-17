using System;

public class skener {
    public static void Main (string[] args) {
        string[] line = Console.ReadLine ().Split (' ');
        int lines = int.Parse (line[0]);
        while (lines-- > 0) {
            char[] current = Console.ReadLine ().ToCharArray ();
            for (int s = 0; s < int.Parse (line[2]); s++) {
                for (int x = 0; x < current.Length; x++) {
                    for (int a = 0; a < int.Parse (line[3]); a++)
                        Console.Write (current[x]);
                }
                Console.WriteLine ();
            }
        }
    }
}