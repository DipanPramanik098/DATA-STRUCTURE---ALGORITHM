package _010_Linked_List._01_Fundamentals_Singly_LL;

public class _07_Insert_Head {

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

    // Function to insert node at head
    public static ListNode insertAtHead(ListNode head, int X) {

        // Step 1: create new node
        ListNode newNode = new ListNode(X);

        // Step 2: link new node to current head
        newNode.next = head;

        // Step 3: move head to new node
        head = newNode;

        // return updated head
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

        int X = 7;

        // insert at head
        head = insertAtHead(head, X);

        System.out.print("After Inserting at Head: ");
        printList(head);
    }
}