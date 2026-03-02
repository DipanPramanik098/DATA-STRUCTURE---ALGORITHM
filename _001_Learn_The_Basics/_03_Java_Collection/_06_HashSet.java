import java.util.HashSet;

public class _06_HashSet {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();

        set.add("One");
        set.add("Two");
        set.add("One"); // Duplicate ignored

        System.out.println(set);

        System.out.println(set.contains("Two"));
        set.remove("One");
    }
}
