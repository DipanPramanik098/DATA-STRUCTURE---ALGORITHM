import java.util.LinkedList;

public class _03_LinkedList {
    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();

        // Add operations
        list.add("A");
        list.addFirst("Start");
        list.addLast("End");

        // Access
        System.out.println(list.getFirst());
        System.out.println(list.getLast());

        // Remove
        list.removeFirst();
        list.removeLast();

        // Queue methods
        list.offer("X");     // add
        list.poll();         // remove head
        list.peek();         // view head

        // Stack methods
        list.push("Stack");
        list.pop();

        System.out.println(list);
    }
}
