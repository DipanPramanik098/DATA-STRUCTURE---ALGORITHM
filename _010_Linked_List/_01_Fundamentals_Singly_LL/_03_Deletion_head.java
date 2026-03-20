package _010_Linked_List._01_Fundamentals_Singly_LL;

public class _03_Deletion_head {

    // Node class
    static class ListNode {
        int data;         // value of node
        ListNode next;    // reference to next node

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

    // Function to delete head of linked list
    public static ListNode deleteHead(ListNode head) {

        // Edge Case 1: empty list
        if (head == null) {
            return null;
        }

        // temp stores current head (just for understanding)
        ListNode temp = head;

        // move head to next node
        head = head.next;

        // break link (optional in Java, for clarity)
        temp = null;

        // return new head
        return head;
    }

    // Utility: insert at head
    public static ListNode insertAtHead(ListNode head, int data) {
        ListNode newNode = new ListNode(data);

        newNode.next = head; // new node points to old head
        head = newNode;      // head becomes new node

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

        ListNode head = null;

        // creating list
        head = insertAtHead(head, 3);
        head = insertAtHead(head, 2);
        head = insertAtHead(head, 1);

        System.out.print("Original List: ");
        printList(head);

        // delete head
        head = deleteHead(head);

        System.out.print("After Deleting Head: ");
        printList(head);
    }
}