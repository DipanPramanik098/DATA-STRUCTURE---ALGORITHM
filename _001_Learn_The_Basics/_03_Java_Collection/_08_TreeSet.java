import java.util.TreeSet;

public class _08_TreeSet {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();

        set.add(5);
        set.add(1);
        set.add(3);

        System.out.println(set); // Sorted
    }
}
