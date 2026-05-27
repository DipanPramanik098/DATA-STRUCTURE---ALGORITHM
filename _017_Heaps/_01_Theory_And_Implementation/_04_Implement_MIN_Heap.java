package _017_Heaps._01_Theory_And_Implementation;

import java.util.ArrayList;

public class _04_Implement_MIN_Heap {

    /*
    ==========================================================
                    IMPLEMENTATION OF MIN HEAP
    ==========================================================

    A Min Heap is a Complete Binary Tree where:

    Parent Node <= Child Nodes

    Smallest element is always present at the ROOT.

    ----------------------------------------------------------
    ARRAY REPRESENTATION
    ----------------------------------------------------------

    For any index i:

    Parent      -> (i - 1) / 2
    Left Child  -> (2 * i) + 1
    Right Child -> (2 * i) + 2

    ----------------------------------------------------------
    OPERATIONS IMPLEMENTED
    ----------------------------------------------------------

    1. initializeHeap()
       -> Initialize empty heap

    2. insert(x)
       -> Insert a new element

    3. getMin()
       -> Return minimum element

    4. extractMin()
       -> Remove minimum element

    5. heapSize()
       -> Return current size

    6. isEmpty()
       -> Check heap is empty or not

    7. changeKey(index, value)
       -> Update a value at particular index

    ----------------------------------------------------------
    INTERNAL FUNCTIONS
    ----------------------------------------------------------

    heapifyUp()
    heapifyDown()

    These functions maintain the Min Heap Property.
    */

    // Dynamic Array used to store heap elements
    private ArrayList<Integer> heap;

    // Constructor
    public _04_Implement_MIN_Heap() {
        heap = new ArrayList<>();
    }

    /*
    ==========================================================
                    INITIALIZE HEAP
    ==========================================================

    Clears all elements from heap.

    Time Complexity  : O(1)
    Space Complexity : O(1)
    */
    public void initializeHeap() {
        heap.clear();
    }

    /*
    ==========================================================
                        INSERT OPERATION
    ==========================================================

    STEPS:
    ------
    1. Insert element at the end.
    2. Heapify Up to maintain Min Heap Property.

    WHY HEAPIFY UP?
    ----------------
    Newly inserted element may be smaller than parent.

    Example:
    --------
            2
          /   \
         5     7

    Insert 1:

            2
          /   \
         5     7
        /
       1

    Since 1 < 5, swap.

            2
          /   \
         1     7
        /
       5

    Since 1 < 2, swap again.

            1
          /   \
         2     7
        /
       5

    Final Heap formed.
    */
    public void insert(int val) {

        // Add element at last
        heap.add(val);

        // Heapify upwards
        heapifyUp(heap.size() - 1);
    }

    /*
    ==========================================================
                        HEAPIFY UP
    ==========================================================

    Used after insertion or decreasing key.

    Continue swapping child with parent
    until Min Heap Property is restored.

    Time Complexity : O(log N)
    */
    private void heapifyUp(int index) {

        // Continue until root node
        while (index > 0) {

            // Parent index
            int parent = (index - 1) / 2;

            // If current node is smaller than parent
            if (heap.get(index) < heap.get(parent)) {

                // Swap
                swap(index, parent);

                // Move upward
                index = parent;
            } else {

                // Heap property satisfied
                break;
            }
        }
    }

    /*
    ==========================================================
                        GET MINIMUM
    ==========================================================

    Root always stores minimum value.

    Time Complexity : O(1)
    */
    public int getMin() {

        if (isEmpty()) {
            throw new RuntimeException("Heap is Empty");
        }

        return heap.get(0);
    }

    /*
    ==========================================================
                        EXTRACT MINIMUM
    ==========================================================

    Removes smallest element from heap.

    STEPS:
    ------
    1. Store root value.
    2. Replace root with last element.
    3. Remove last element.
    4. Heapify Down.

    WHY HEAPIFY DOWN?
    -----------------
    Root may violate heap property after replacement.

    Time Complexity : O(log N)
    */
    public int extractMin() {

        if (isEmpty()) {
            throw new RuntimeException("Heap is Empty");
        }

        // Minimum element
        int min = heap.get(0);

        // Last element
        int last = heap.get(heap.size() - 1);

        // Put last element at root
        heap.set(0, last);

        // Remove last element
        heap.remove(heap.size() - 1);

        // Heapify only if heap not empty
        if (!isEmpty()) {
            heapifyDown(0);
        }

        return min;
    }

    /*
    ==========================================================
                        HEAPIFY DOWN
    ==========================================================

    Used after deletion or increasing key.

    Compare current node with children.
    Swap with smallest child if needed.

    Time Complexity : O(log N)
    */
    private void heapifyDown(int index) {

        int size = heap.size();

        while (true) {

            int left = (2 * index) + 1;
            int right = (2 * index) + 2;

            // Assume current node is smallest
            int smallest = index;

            // Check left child
            if (left < size &&
                    heap.get(left) < heap.get(smallest)) {

                smallest = left;
            }

            // Check right child
            if (right < size &&
                    heap.get(right) < heap.get(smallest)) {

                smallest = right;
            }

            // If smallest is not current node
            if (smallest != index) {

                swap(index, smallest);

                // Move downward
                index = smallest;

            } else {

                // Heap property restored
                break;
            }
        }
    }

    /*
    ==========================================================
                        CHANGE KEY
    ==========================================================

    Update value at a particular index.

    CASE 1:
    --------
    New value is SMALLER
    -> Heapify Up

    CASE 2:
    --------
    New value is GREATER
    -> Heapify Down

    Time Complexity : O(log N)
    */
    public void changeKey(int index, int newValue) {

        if (index < 0 || index >= heap.size()) {
            throw new RuntimeException("Invalid Index");
        }

        // Old value
        int oldValue = heap.get(index);

        // Update value
        heap.set(index, newValue);

        // If value decreased
        if (newValue < oldValue) {

            heapifyUp(index);

        } else {

            heapifyDown(index);
        }
    }

    /*
    ==========================================================
                        HEAP SIZE
    ==========================================================

    Returns number of elements.

    Time Complexity : O(1)
    */
    public int heapSize() {
        return heap.size();
    }

    /*
    ==========================================================
                        IS EMPTY
    ==========================================================

    Returns true if heap is empty.

    Time Complexity : O(1)
    */
    public boolean isEmpty() {
        return heap.size() == 0;
    }

    /*
    ==========================================================
                            SWAP
    ==========================================================

    Utility function to swap two indices.
    */
    private void swap(int i, int j) {

        int temp = heap.get(i);

        heap.set(i, heap.get(j));

        heap.set(j, temp);
    }

    /*
    ==========================================================
                        PRINT HEAP
    ==========================================================
    */
    public void printHeap() {
        System.out.println(heap);
    }

    /*
    ==========================================================
                            MAIN METHOD
    ==========================================================

    Dry Run Example
    */
    public static void main(String[] args) {

        _04_Implement_MIN_Heap minHeap =
                new _04_Implement_MIN_Heap();

        /*
        ------------------------------------------------------
                        INITIALIZE HEAP
        ------------------------------------------------------
        */
        minHeap.initializeHeap();

        /*
        ------------------------------------------------------
                            INSERT
        ------------------------------------------------------
        */
        minHeap.insert(10);
        minHeap.insert(4);
        minHeap.insert(15);
        minHeap.insert(2);
        minHeap.insert(8);

        System.out.println("Heap After Insertions:");
        minHeap.printHeap();

        /*
        ------------------------------------------------------
                            GET MIN
        ------------------------------------------------------
        */
        System.out.println("\nMinimum Element:");
        System.out.println(minHeap.getMin());

        /*
        ------------------------------------------------------
                            HEAP SIZE
        ------------------------------------------------------
        */
        System.out.println("\nHeap Size:");
        System.out.println(minHeap.heapSize());

        /*
        ------------------------------------------------------
                            IS EMPTY
        ------------------------------------------------------
        */
        System.out.println("\nIs Heap Empty?");
        System.out.println(minHeap.isEmpty());

        /*
        ------------------------------------------------------
                            EXTRACT MIN
        ------------------------------------------------------
        */
        System.out.println("\nExtracted Minimum:");
        System.out.println(minHeap.extractMin());

        System.out.println("\nHeap After Extraction:");
        minHeap.printHeap();

        /*
        ------------------------------------------------------
                            CHANGE KEY
        ------------------------------------------------------
        */
        System.out.println("\nChange Index 2 to 1");

        minHeap.changeKey(2, 1);

        System.out.println("\nHeap After changeKey:");
        minHeap.printHeap();
    }
}