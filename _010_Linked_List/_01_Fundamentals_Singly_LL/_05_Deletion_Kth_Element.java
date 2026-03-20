package _010_Linked_List._01_Fundamentals_Singly_LL;

public class _05_Deletion_Kth_Element {

    // Node class
    static class ListNode {
        int data;          // value of node
        ListNode next;     // reference to next node

        ListNode() {
            this.data = 0;
            this.next = null;
        }

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }

        ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }
    }

    // Function to delete Kth node
    public static ListNode deleteKthNode(ListNode head, int k) {

        // Edge Case 1: empty list
        if (head == null) {
            return null;
        }

        // Edge Case 2: delete first node (head)
        if (k == 1) {
            return head.next;
        }

        // temp pointer to traverse
        ListNode temp = head;

        // move to (k-1)th node
        for (int i = 1; temp != null && i < k - 1; i++) {
            temp = temp.next;
        }

        // if k is out of bounds
        if (temp == null || temp.next == null) {
            return head;
        }

        // delete kth node
        temp.next = temp.next.next;

        return head;
    }

    // Utility: print linked list
    public static void printList(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        /*
            Example:
            3 -> 4 -> 5 -> null
        */

        ListNode head = new ListNode(3);
        head.next = new ListNode(4);
        head.next.next = new ListNode(5);

        System.out.print("Original List: ");
        printList(head);

        int k = 2;

        // delete kth node
        head = deleteKthNode(head, k);

        System.out.print("After Deleting Kth Node: ");
        printList(head);
    }
}