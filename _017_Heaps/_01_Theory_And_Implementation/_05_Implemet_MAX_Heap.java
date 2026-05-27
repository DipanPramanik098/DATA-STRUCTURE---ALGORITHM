package _017_Heaps._01_Theory_And_Implementation;

import java.util.ArrayList;

public class _05_Implemet_MAX_Heap {

    /*
    ==========================================================
                    IMPLEMENTATION OF MAX HEAP
    ==========================================================

    A Max Heap is a Complete Binary Tree where:

            Parent Node >= Child Nodes

    Largest element is always present at ROOT.

    ----------------------------------------------------------
                    ARRAY REPRESENTATION
    ----------------------------------------------------------

    For a node present at index i:

    Parent Index      = (i - 1) / 2
    Left Child Index  = (2 * i) + 1
    Right Child Index = (2 * i) + 2

    ----------------------------------------------------------
                    OPERATIONS IMPLEMENTED
    ----------------------------------------------------------

    1. initializeHeap()
       -> Initialize empty heap

    2. insert(x)
       -> Insert a new value

    3. getMax()
       -> Return maximum element

    4. extractMax()
       -> Remove maximum element

    5. heapSize()
       -> Return current heap size

    6. isEmpty()
       -> Check heap empty or not

    7. changeKey(index, value)
       -> Update value at given index

    ----------------------------------------------------------
                    INTERNAL FUNCTIONS
    ----------------------------------------------------------

    heapifyUp()
    heapifyDown()

    These functions maintain the Max Heap Property.
    */

    // Dynamic Array used to store heap elements
    private ArrayList<Integer> heap;

    // Constructor
    public _05_Implemet_MAX_Heap() {
        heap = new ArrayList<>();
    }

    /*
    ==========================================================
                    INITIALIZE HEAP
    ==========================================================

    Clears all heap elements.

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
    1. Insert element at last position.
    2. Heapify upwards.

    WHY HEAPIFY UP?
    ----------------
    Inserted value may become larger than parent.

    Example:
    --------

            20
           /  \
         15    10

    Insert 30:

            20
           /  \
         15    10
         /
       30

    Since 30 > 15, swap.

            20
           /  \
         30    10
         /
       15

    Since 30 > 20, swap again.

            30
           /  \
         20    10
         /
       15

    Max Heap restored.
    */
    public void insert(int val) {

        // Insert at end
        heap.add(val);

        // Heapify upwards
        heapifyUp(heap.size() - 1);
    }

    /*
    ==========================================================
                        HEAPIFY UP
    ==========================================================

    Used after insertion or increasing key.

    Compare current node with parent.
    Swap if current node is greater.

    Time Complexity : O(log N)
    */
    private void heapifyUp(int index) {

        while (index > 0) {

            // Parent index
            int parent = (index - 1) / 2;

            // If child is greater than parent
            if (heap.get(index) > heap.get(parent)) {

                swap(index, parent);

                // Move upward
                index = parent;
            } else {

                // Max Heap property satisfied
                break;
            }
        }
    }

    /*
    ==========================================================
                        GET MAXIMUM
    ==========================================================

    Root always contains largest value.

    Time Complexity : O(1)
    */
    public int getMax() {

        if (isEmpty()) {
            throw new RuntimeException("Heap is Empty");
        }

        return heap.get(0);
    }

    /*
    ==========================================================
                        EXTRACT MAXIMUM
    ==========================================================

    Removes largest element from heap.

    STEPS:
    ------
    1. Store root value.
    2. Replace root with last element.
    3. Remove last element.
    4. Heapify Down.

    WHY HEAPIFY DOWN?
    -----------------
    Root may violate max heap property.

    Time Complexity : O(log N)
    */
    public int extractMax() {

        if (isEmpty()) {
            throw new RuntimeException("Heap is Empty");
        }

        // Store maximum value
        int max = heap.get(0);

        // Last element
        int last = heap.get(heap.size() - 1);

        // Replace root with last element
        heap.set(0, last);

        // Remove last element
        heap.remove(heap.size() - 1);

        // Heapify if heap not empty
        if (!isEmpty()) {
            heapifyDown(0);
        }

        return max;
    }

    /*
    ==========================================================
                        HEAPIFY DOWN
    ==========================================================

    Used after deletion or decreasing key.

    Compare current node with children.
    Swap with largest child.

    IMPORTANT:
    ----------
    If both children are equal,
    ALWAYS swap with LEFT CHILD.

    Time Complexity : O(log N)
    */
    private void heapifyDown(int index) {

        int size = heap.size();

        while (true) {

            int left = (2 * index) + 1;
            int right = (2 * index) + 2;

            // Assume current node is largest
            int largest = index;

            // Check left child
            if (left < size &&
                    heap.get(left) > heap.get(largest)) {

                largest = left;
            }

            /*
            IMPORTANT CONDITION:
            --------------------
            Use STRICTLY GREATER only.

            This ensures:
            If left and right are equal,
            LEFT child remains selected.
            */
            if (right < size &&
                    heap.get(right) > heap.get(largest)) {

                largest = right;
            }

            // If largest changed
            if (largest != index) {

                swap(index, largest);

                // Move downward
                index = largest;

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

    Update value at a given index.

    CASE 1:
    --------
    New value is GREATER
    -> Heapify Up

    CASE 2:
    --------
    New value is SMALLER
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

        // If value increased
        if (newValue > oldValue) {

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

        _05_Implemet_MAX_Heap maxHeap =
                new _05_Implemet_MAX_Heap();

        /*
        ------------------------------------------------------
                        INITIALIZE HEAP
        ------------------------------------------------------
        */
        maxHeap.initializeHeap();

        /*
        ------------------------------------------------------
                            INSERT
        ------------------------------------------------------
        */
        maxHeap.insert(4);
        maxHeap.insert(1);
        maxHeap.insert(10);
        maxHeap.insert(20);
        maxHeap.insert(15);

        System.out.println("Heap After Insertions:");
        maxHeap.printHeap();

        /*
        ------------------------------------------------------
                            GET MAX
        ------------------------------------------------------
        */
        System.out.println("\nMaximum Element:");
        System.out.println(maxHeap.getMax());

        /*
        ------------------------------------------------------
                            HEAP SIZE
        ------------------------------------------------------
        */
        System.out.println("\nHeap Size:");
        System.out.println(maxHeap.heapSize());

        /*
        ------------------------------------------------------
                            IS EMPTY
        ------------------------------------------------------
        */
        System.out.println("\nIs Heap Empty?");
        System.out.println(maxHeap.isEmpty());

        /*
        ------------------------------------------------------
                            EXTRACT MAX
        ------------------------------------------------------
        */
        System.out.println("\nExtracted Maximum:");
        System.out.println(maxHeap.extractMax());

        System.out.println("\nHeap After Extraction:");
        maxHeap.printHeap();

        /*
        ------------------------------------------------------
                            CHANGE KEY
        ------------------------------------------------------
        */
        System.out.println("\nChange Index 2 to 50");

        maxHeap.changeKey(2, 50);

        System.out.println("\nHeap After changeKey:");
        maxHeap.printHeap();
    }
}