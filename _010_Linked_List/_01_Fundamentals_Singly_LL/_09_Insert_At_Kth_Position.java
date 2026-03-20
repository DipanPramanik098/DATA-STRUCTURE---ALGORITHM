package _010_Linked_List._01_Fundamentals_Singly_LL;

public class _09_Insert_At_Kth_Position {

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

    // Function to insert node at Kth position (1-based index)
    public static ListNode insertAtKthPosition(ListNode head, int X, int K) {

        // Case 1: Empty list
        if (head == null) {
            if (K == 1) return new ListNode(X);
            return head;
        }

        // Case 2: Insert at head
        if (K == 1) {
            return new ListNode(X, head);
        }

        ListNode temp = head;
        int count = 1;

        // Traverse to (K-1)th node
        while (temp != null) {

            if (count == K - 1) {

                // Create new node and link
                ListNode newNode = new ListNode(X, temp.next);
                temp.next = newNode;

                break;
            }

            temp = temp.next;
            count++;
        }

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
            1 -> 2 -> 3 -> null
        */

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        System.out.print("Original List: ");
        printList(head);

        int X = 5;
        int K = 2;

        // insert at kth position
        head = insertAtKthPosition(head, X, K);

        System.out.print("After Inserting at Kth Position: ");
        printList(head);
    }
}