import java.io.*;
import java.util.*;

public class classy {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("[\\s:]+");
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Person[] arr = new Person[n];
            for (int x = 0; x < n; x++) {
                String name = sc.next();
                Stack<String> st = new Stack<>();
                for (String s : sc.next().split("-"))
                    st.add(s);
                sc.next();
                String[] list = new String[10];
                int size = st.size();
                for (int a = 0; a < size; a++)
                    list[a] = st.pop();
                for (int a = size; a < list.length; a++)
                    list[a] = "middle";
                arr[x] = new Person(name, list);
            }
            Arrays.sort(arr);
            for (Person p : arr)
                System.out.println(p.name);
            System.out.println("==============================");
        }
    }

    static class Person implements Comparable<Person> {
        String name;
        String[] arr;

        public Person(String a, String[] b) {
            name = a;
            arr = b;
        }

        public int compareTo(Person p) {
            for (int x = 0; x < 10; x++) {
                int ret = -arr[x].compareTo(p.arr[x]);
                if (ret != 0)
                    return ret;
            }
            return name.compareTo(p.name);
        }
    }
}