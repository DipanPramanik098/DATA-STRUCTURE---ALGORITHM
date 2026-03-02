import java.util.*;

/*
 * CollectionsAndQueueDemo
 * Covers:
 * 1. Collections Utility Methods
 * 2. Arrays Utility Methods
 * 3. Queue Interface
 * 4. PriorityQueue
 * 5. ArrayDeque
 */

public class _15_CollectionsAndQueueDemo {

    public static void main(String[] args) {

        // =========================
        // 1️⃣ Collections Utility
        // =========================

        List<Integer> list = new ArrayList<>(Arrays.asList(3, 1, 2, 2, 5));

        // sort()
        Collections.sort(list);
        System.out.println("Sorted: " + list);

        // reverse()
        Collections.reverse(list);
        System.out.println("Reversed: " + list);

        // max() & min()
        System.out.println("Max: " + Collections.max(list));
        System.out.println("Min: " + Collections.min(list));

        // frequency()
        System.out.println("Frequency of 2: " + Collections.frequency(list, 2));

        // binarySearch() (Must be sorted)
        Collections.sort(list);
        System.out.println("Binary Search index of 3: " +
                Collections.binarySearch(list, 3));

        // shuffle()
        Collections.shuffle(list);
        System.out.println("Shuffled: " + list);

        // swap()
        Collections.swap(list, 0, 1);
        System.out.println("After Swap: " + list);

        // fill()
        Collections.fill(list, 100);
        System.out.println("After Fill: " + list);

        // =========================
        // 2️⃣ Arrays Utility
        // =========================

        int[] arr = {3, 1, 2};

        Arrays.sort(arr);
        System.out.println("\nArray Sorted: " + Arrays.toString(arr));

        System.out.println("Binary Search (2): " +
                Arrays.binarySearch(arr, 2));

        Arrays.fill(arr, 5);
        System.out.println("After Fill: " + Arrays.toString(arr));

        int[] arr2 = {5, 5, 5};
        System.out.println("Arrays Equal: " +
                Arrays.equals(arr, arr2));

        int[][] matrix = {{1, 2}, {3, 4}};
        System.out.println("Deep ToString: " +
                Arrays.deepToString(matrix));

        // =========================
        // 3️⃣ Queue (LinkedList)
        // =========================

        Queue<String> queue = new LinkedList<>();

        queue.add("A");     // insert
        queue.offer("B");   // insert safely

        System.out.println("\nQueue Peek: " + queue.peek());
        System.out.println("Queue Poll: " + queue.poll());
        System.out.println("Queue After Poll: " + queue);

        // =========================
        // 4️⃣ PriorityQueue (Min Heap)
        // =========================

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(30);
        pq.add(10);
        pq.add(20);

        System.out.println("\nPriorityQueue (Min Heap):");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

        // =========================
        // 5️⃣ ArrayDeque (Best for Stack + Queue)
        // =========================

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        // As Queue
        deque.addLast(10);
        deque.addLast(20);

        // As Stack
        deque.push(5);

        System.out.println("\nArrayDeque Remove First: " +
                deque.removeFirst());

        System.out.println("ArrayDeque Pop: " +
                deque.pop());

        System.out.println("Final Deque: " + deque);
    }
}