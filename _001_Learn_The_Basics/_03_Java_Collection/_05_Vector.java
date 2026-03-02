import java.util.Vector;

public class _05_Vector {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();

        vector.add("Red");
        vector.add("Blue");

        // capacity()
        System.out.println(vector.capacity());
    }
}
