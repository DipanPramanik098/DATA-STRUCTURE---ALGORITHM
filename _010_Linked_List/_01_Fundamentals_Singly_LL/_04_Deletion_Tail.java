package _010_Linked_List._01_Fundamentals_Singly_LL;

public class _04_Deletion_Tail {

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

    // Function to delete tail node
    public static ListNode deleteTail(ListNode head) {

        // Edge Case 1: empty list OR single node
        if (head == null || head.next == null) {
            return null; // list becomes empty
        }

        // temp pointer to traverse
        ListNode temp = head;

        // move to second last node
        while (temp.next.next != null) {
            temp = temp.next;
        }

        // remove last node
        temp.next = null;

        return head;
    }

    // Utility: insert at head
    public static ListNode insertAtHead(ListNode head, int data) {
        ListNode newNode = new ListNode(data);

        newNode.next = head;
        head = newNode;

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

        ListNode head = null;

        head = insertAtHead(head, 3);
        head = insertAtHead(head, 2);
        head = insertAtHead(head, 1);

        System.out.print("Original List: ");
        printList(head);

        // delete tail
        head = deleteTail(head);

        System.out.print("After Deleting Tail: ");
        printList(head);
    }
}