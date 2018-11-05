import java.io.*;
import java.util.*;

public class iwannabe {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] tokens = sc.readLine().split(" ");
        int cases = Integer.parseInt(tokens[0]);
        int k = Integer.parseInt(tokens[1]);
        Pokemon[] attack = new Pokemon[cases];
        Pokemon[] defense = new Pokemon[cases];
        Pokemon[] health = new Pokemon[cases];
        for (int x = 0; x < cases; x++)
            attack[x] = defense[x] = health[x] = new Pokemon(sc.readLine().split(" "));
        Arrays.sort(attack, new AtkCompare());
        Arrays.sort(defense, new DefCompare());
        Arrays.sort(health, new HealthCompare());
        int count = 0;
        for (int x = 0; x < k; x++, count++)
            attack[x].taken = true;
        for (int x = 0; x < k; x++)
            if (!defense[x].taken) {
                defense[x].taken = true;
                count++;
            }
        for (int x = 0; x < k; x++)
            if (!health[x].taken)
                count++;
        dc.write(count + "\n");

        dc.close();
        sc.close();
    }
}

class Pokemon {
    public long a, d, h;
    public boolean taken;

    public Pokemon(String[] stats) {
        this.a = Long.parseLong(stats[0]);
        this.d = Long.parseLong(stats[1]);
        this.h = Long.parseLong(stats[2]);
        taken = false;
    }
}

class AtkCompare implements Comparator {
    @Override
    public int compare(Object q, Object w) {
        Pokemon a = (Pokemon) q;
        Pokemon b = (Pokemon) w;
        return a.a < b.a ? 1 : a.a > b.a ? -1 : 0;
    }

}

class DefCompare implements Comparator {
    @Override
    public int compare(Object q, Object w) {
        Pokemon a = (Pokemon) q;
        Pokemon b = (Pokemon) w;
        return a.d < b.d ? 1 : a.d > b.d ? -1 : 0;
    }
}

class HealthCompare implements Comparator {
    @Override
    public int compare(Object q, Object w) {
        Pokemon a = (Pokemon) q;
        Pokemon b = (Pokemon) w;
        return a.h < b.h ? 1 : a.h > b.h ? -1 : 0;
    }
}