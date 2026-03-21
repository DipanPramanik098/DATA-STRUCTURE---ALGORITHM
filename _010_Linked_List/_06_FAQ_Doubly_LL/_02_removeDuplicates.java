package _010_Linked_List._06_FAQ_Doubly_LL;

// Node class for Doubly Linked List
class ListNode {
    int val;
    ListNode next;
    ListNode prev;

    ListNode(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

public class _02_removeDuplicates {

    // Function to remove duplicates from sorted DLL
    public ListNode removeDuplicates(ListNode head) {
        // If list is empty or has only one node
        if (head == null || head.next == null) {
            return head;
        }

        // Start traversing from head
        ListNode temp = head;

        // Traverse until last node
        while (temp != null && temp.next != null) {

            // Start from next node
            ListNode nextNode = temp.next;

            // Skip all duplicate nodes
            while (nextNode != null && nextNode.val == temp.val) {
                nextNode = nextNode.next;
            }

            // Connect current node to first non-duplicate node
            temp.next = nextNode;

            // Update previous pointer of nextNode
            if (nextNode != null) {
                nextNode.prev = temp;
            }

            // Move temp forward
            temp = temp.next;
        }

        return head;
    }

    // Helper function to insert node at end
    public static ListNode insertAtEnd(ListNode head, int val) {
        ListNode newNode = new ListNode(val);

        // If list is empty
        if (head == null) {
            return newNode;
        }

        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;

        return head;
    }

    // Function to print DLL
    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val);
            if (temp.next != null) {
                System.out.print(" <-> ");
            }
            temp = temp.next;
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        _02_removeDuplicates obj = new _02_removeDuplicates();

        // Example list: 1 <-> 1 <-> 3 <-> 3 <-> 4 <-> 5
        ListNode head = null;
        head = insertAtEnd(head, 1);
        head = insertAtEnd(head, 1);
        head = insertAtEnd(head, 3);
        head = insertAtEnd(head, 3);
        head = insertAtEnd(head, 4);
        head = insertAtEnd(head, 5);

        System.out.println("Original List:");
        printList(head);

        head = obj.removeDuplicates(head);

        System.out.println("After Removing Duplicates:");
        printList(head);

        // Edge case test
        ListNode head2 = null;
        head2 = insertAtEnd(head2, 1);
        head2 = insertAtEnd(head2, 1);
        head2 = insertAtEnd(head2, 1);
        head2 = insertAtEnd(head2, 1);
        head2 = insertAtEnd(head2, 2);

        System.out.println("\nOriginal List 2:");
        printList(head2);

        head2 = obj.removeDuplicates(head2);

        System.out.println("After Removing Duplicates:");
        printList(head2);
    }
}