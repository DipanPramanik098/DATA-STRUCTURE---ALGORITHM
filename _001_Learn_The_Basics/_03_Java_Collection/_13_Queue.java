import java.util.LinkedList;
import java.util.Queue;

public class _13_Queue {
    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<>();

        // Insert
        queue.add("A");
        queue.offer("B");

        // View head
        System.out.println(queue.peek());

        // Remove head
        System.out.println(queue.poll());

        System.out.println(queue);
    }
}
