import java.util.ArrayList;
import java.util.Random;

public class gen {
    public static void main(String[] args) {
        Random rand = new Random();

        int villagers = rand.nextInt(100) + 1;
        int evenings = rand.nextInt(50) + 1;
        int temp = evenings;

        System.out.println(villagers);
        System.out.println(evenings);

        ArrayList<Integer> presentEachNight = new ArrayList<>();
        ArrayList<Integer> attended = new ArrayList<>();

        int count = 0;
        while (count < 1) {
            while (temp-- > 0) {
                int present = rand.nextInt(villagers - 1) + 2;
                presentEachNight.add(present);
                ArrayList<Integer> who = new ArrayList<>();
                while (present-- > 0) {
                    int random = rand.nextInt(villagers) + 1;
                    if (!who.contains(random)) {
                        attended.add(random);
                        who.add(random);
                    } else {
                        present++;
                    }
                }
                if (attended.contains(1))
                    count++;
            }
            temp = evenings;
        }
        for (int x = 0; x < presentEachNight.size(); x++) {
            int present = presentEachNight.get(x);
            System.out.print(present + " ");
            for (int s = 0; s < present; s++) {
                System.out.print(attended.get(0) + " ");
                attended.remove(0);
            }
            System.out.println();
        }
    }
}
