import java.util.ArrayList;
import java.util.Random;

public class gen {
    public static void main(String[] args) {
        Random rand = new Random();

        int villagers = rand.nextInt(100) + 1;
        int evenings = rand.nextInt(50) + 1;

        System.out.println(villagers);
        System.out.println(evenings);

        while (evenings-- > 0) {
            int present = rand.nextInt(villagers - 2) + 2;
            System.out.print(present + " ");
            ArrayList<Integer> who = new ArrayList<>();
            while (present-- > 0) {
                int random = rand.nextInt(villagers) + 1;
                if (!who.contains(random))
                    who.add(random);
                else
                    present++;
            }
            for (int x : who)
                System.out.print(x + " ");
            System.out.println();
        }

    }
}
