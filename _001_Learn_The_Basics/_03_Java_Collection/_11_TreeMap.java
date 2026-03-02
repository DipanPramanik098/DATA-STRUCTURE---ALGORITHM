import java.util.TreeMap;

public class _11_TreeMap {
    public static void main(String[] args) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        treeMap.put("Orange", 5);
        treeMap.put("Apple", 10);

        System.out.println(treeMap); // Sorted by key
    }
}
