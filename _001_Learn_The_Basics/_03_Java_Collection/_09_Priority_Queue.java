import java.util.Collections;
import java.util.PriorityQueue;

public class _09_Priority_Queue {
    public static void main(String[] args) {

        // 🔷 Creating a Min Heap (Default PriorityQueue)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // ===============================
        // INSERTION METHODS
        // ===============================

        pq.add(30);        // add() → Inserts element (O(log n))
        pq.offer(10);      // offer() → Inserts element (O(log n))
        pq.add(20);

        System.out.println("Initial Queue: " + pq);

        // ===============================
        // ACCESS METHODS
        // ===============================

        System.out.println("peek(): " + pq.peek());     // Returns smallest element (O(1))
        System.out.println("element(): " + pq.element()); // Same as peek but throws exception if empty

        // ===============================
        // REMOVAL METHODS
        // ===============================

        System.out.println("poll(): " + pq.poll());     // Removes smallest element (O(log n))
        System.out.println("After poll(): " + pq);

        System.out.println("remove(): " + pq.remove()); // Removes smallest element
        System.out.println("After remove(): " + pq);

        // Add elements again
        pq.add(50);
        pq.add(40);
        pq.add(60);

        System.out.println("After adding more elements: " + pq);

        // Remove specific element
        pq.remove(50);   // O(n)
        System.out.println("After remove(50): " + pq);

        // ===============================
        // UTILITY METHODS
        // ===============================

        System.out.println("size(): " + pq.size());          // Number of elements
        System.out.println("isEmpty(): " + pq.isEmpty());    // Check empty
        System.out.println("contains(40): " + pq.contains(40)); // O(n)

        // ===============================
        // ITERATION (Not Sorted Order)
        // ===============================

        System.out.println("Iterating using for-each:");
        for (Integer val : pq) {
            System.out.println(val);
        }

        // ===============================
        // SORTED REMOVAL
        // ===============================

        System.out.println("Removing in sorted order:");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

        // ===============================
        // MAX HEAP Example
        // ===============================

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        maxHeap.add(10);
        maxHeap.add(30);
        maxHeap.add(20);

        System.out.println("Max Heap poll(): " + maxHeap.poll()); // Removes largest element

        // ===============================
        // CLEAR METHOD
        // ===============================

        maxHeap.clear();
        System.out.println("After clear(), isEmpty(): " + maxHeap.isEmpty());
    }
}
