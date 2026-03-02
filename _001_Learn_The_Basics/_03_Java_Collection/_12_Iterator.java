import java.util.*;

public class _12_Iterator {
    public static void main(String[] args) {

        // 🔷 Creating a List
        List<String> list = new ArrayList<>();

        list.add("Java");
        list.add("Python");
        list.add("C++");
        list.add("JavaScript");

        // 🔷 Getting Iterator from list
        Iterator<String> it = list.iterator();

        // 🔷 Traversing using Iterator
        while (it.hasNext()) {      // Checks if next element exists
            System.out.println(it.next());  // Returns next element
        }
    }
}