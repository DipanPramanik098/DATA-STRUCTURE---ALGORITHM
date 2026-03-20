package _010_Linked_List._01_Fundamentals_Singly_LL;

public class _06_Deletion_Based_On_Value {

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

    // Function to delete node with value X
    public static ListNode deleteNodeWithValueX(ListNode head, int X) {

        // Edge Case 1: empty list
        if (head == null) {
            return head;
        }

        // Edge Case 2: if head itself has value X
        if (head.data == X) {
            return head.next; // delete head
        }

        // temp pointer for traversal
        ListNode temp = head;

        // prev pointer to track previous node
        ListNode prev = null;

        // traverse the linked list
        while (temp != null) {

            // if value found
            if (temp.data == X) {

                // skip the current node
                prev.next = temp.next;

                return head;
            }

            // move pointers forward
            prev = temp;
            temp = temp.next;
        }

        // if value not found, return original list
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

        int X = 5;

        // delete node with value X
        head = deleteNodeWithValueX(head, X);

        System.out.print("After Deleting Value " + X + ": ");
        printList(head);
    }
}