package _010_Linked_List._01_Fundamentals_Singly_LL;

public class _10_Insert_Before_value_X {

    // Node class
    static class ListNode {
        int data;          // value of node
        ListNode next;     // reference to next node

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }

        ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }
    }

    // Function to insert before value X
    public static ListNode insertBeforeX(ListNode head, int X, int val) {

        // Edge Case 1: empty list
        if (head == null) {
            return null;
        }

        // Edge Case 2: insert before head
        if (head.data == X) {
            return new ListNode(val, head);
        }

        // temp pointer for traversal
        ListNode temp = head;

        // traverse list
        while (temp.next != null) {

            // if next node has value X
            if (temp.next.data == X) {

                // create new node
                ListNode newNode = new ListNode(val, temp.next);

                // insert node
                temp.next = newNode;

                break;
            }

            temp = temp.next;
        }

        return head;
    }

    // Utility: print list
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
            1 -> 2 -> 3 -> null
        */

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        System.out.print("Original List: ");
        printList(head);

        int X = 2;
        int val = 5;

        // insert before X
        head = insertBeforeX(head, X, val);

        System.out.print("After Inserting Before " + X + ": ");
        printList(head);
    }
}