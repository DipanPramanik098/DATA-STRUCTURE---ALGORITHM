import java.util.*;

public class _02_ArrayList {
    public static void main(String[] args) {

        // Creating ArrayList
        ArrayList<String> list = new ArrayList<>();

        // 1. add(E e) → Adds element at end
        list.add("Apple");
        list.add("Banana");

        // 2. add(int index, E element)
        list.add(1, "Mango"); 

        // 3. size() → Returns number of elements
        System.out.println("Size: " + list.size());

        // 4. get(int index) → Access element
        System.out.println("Element at 1: " + list.get(1));

        // 5. set(int index, E element) → Replace element
        list.set(1, "Orange");

        // 6. contains(Object o) → Checks presence
        System.out.println(list.contains("Apple"));

        // 7. remove(Object o)
        list.remove("Banana");

        // 8. remove(int index)
        list.remove(0);

        // 9. isEmpty()
        System.out.println(list.isEmpty());

        // 10. indexOf(Object o)
        list.add("Kiwi");
        System.out.println(list.indexOf("Kiwi"));

        // 11. lastIndexOf(Object o)
        list.add("Kiwi");
        System.out.println(list.lastIndexOf("Kiwi"));

        // 12. clear() → Removes all elements
        // list.clear();

        // 13. toArray()
        Object[] arr = list.toArray();

        // 14. forEach (Java 8)
        list.forEach(System.out::println);
    }
}