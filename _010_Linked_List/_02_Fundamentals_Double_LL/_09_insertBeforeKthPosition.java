package _010_Linked_List._02_Fundamentals_Double_LL;

public class _09_insertBeforeKthPosition {

    // Node class for Doubly Linked List
    static class ListNode {
        int data;          // value of node
        ListNode prev;     // pointer to previous node
        ListNode next;     // pointer to next node

        ListNode() {
            this.data = 0;
            this.prev = null;
            this.next = null;
        }

        ListNode(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }

        ListNode(int data, ListNode prev, ListNode next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    // Function to insert a node before the Kth node (1-based index)
    public static ListNode insertBeforeKthPosition(ListNode head, int X, int K) {

        // Edge Case 1: empty list
        if (head == null) {
            return null;
        }

        // Edge Case 2: insert before head
        if (K == 1) {
            ListNode newHead = new ListNode(X, null, head);
            head.prev = newHead;
            return newHead;
        }

        ListNode temp = head;
        int count = 1;

        // Move temp to the Kth node
        while (temp != null && count < K) {
            temp = temp.next;
            count++;
        }

        // Safety check: if K is invalid, return original head
        if (temp == null) {
            return head;
        }

        // Node before Kth node
        ListNode previousNode = temp.prev;

        // Create new node
        ListNode newNode = new ListNode(X, previousNode, temp);

        // Update links
        previousNode.next = newNode;
        temp.prev = newNode;

        return head;
    }

    // Helper: convert array to doubly linked list
    public static ListNode arrayToDLL(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        ListNode head = new ListNode(nums[0]);
        ListNode prev = head;

        for (int i = 1; i < nums.length; i++) {
            ListNode temp = new ListNode(nums[i], prev, null);
            prev.next = temp;
            prev = temp;
        }

        return head;
    }

    // Helper: print DLL
    public static void printDLL(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        int[] nums = {4, 5};

        // Creating the doubly linked list
        ListNode head = arrayToDLL(nums);

        System.out.print("Original List: ");
        printDLL(head);

        // Insert 10 before 2nd node
        head = insertBeforeKthPosition(head, 10, 2);

        System.out.print("Modified List: ");
        printDLL(head);
    }
}