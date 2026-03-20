package _010_Linked_List._01_Fundamentals_Singly_LL;

public class _08_Insert_Tail {

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

    // Function to insert at tail
    public static ListNode insertAtTail(ListNode head, int X) {

        // Step 1: If list is empty
        if (head == null) {
            return new ListNode(X); // new node becomes head
        }

        // Step 2: Traverse to last node
        ListNode temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        // Step 3: Create new node
        ListNode newNode = new ListNode(X);

        // Step 4: Attach new node at end
        temp.next = newNode;

        // Step 5: Return head
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

        // insert at tail
        head = insertAtTail(head, X);

        System.out.print("After Inserting at Tail: ");
        printList(head);
    }
}