package _010_Linked_List._07_Contest;

// Definition of Singly Linked List
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class _01_removeBadElements {

    // Function to remove all occurrences of val
    public ListNode removeBadElements(ListNode head, int val) {

        // Step 1: Remove nodes from beginning (head)
        while (head != null && head.val == val) {
            head = head.next;
        }

        // Step 2: Traverse remaining list
        ListNode temp = head;

        while (temp != null && temp.next != null) {

            // If next node needs deletion
            if (temp.next.val == val) {
                temp.next = temp.next.next; // skip node
            } else {
                temp = temp.next; // move forward
            }
        }

        return head;
    }

    // Helper function to insert at end
    public static ListNode insert(ListNode head, int val) {
        ListNode newNode = new ListNode(val);

        if (head == null) return newNode;

        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        return head;
    }

    // Print function
    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val);
            if (temp.next != null) System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    // MAIN METHOD
    public static void main(String[] args) {

        _01_removeBadElements obj = new _01_removeBadElements();

        // Create list: 3 -> 4 -> 1 -> 3 -> 5 -> 7
        ListNode head = null;
        head = insert(head, 3);
        head = insert(head, 4);
        head = insert(head, 1);
        head = insert(head, 3);
        head = insert(head, 5);
        head = insert(head, 7);

        System.out.println("Original List:");
        printList(head);

        int val = 3;

        head = obj.removeBadElements(head, val);

        System.out.println("After Removing " + val + ":");
        printList(head);

        // Edge Case: All nodes same
        ListNode head2 = null;
        head2 = insert(head2, 3);
        head2 = insert(head2, 3);
        head2 = insert(head2, 3);

        System.out.println("\nOriginal List 2:");
        printList(head2);

        head2 = obj.removeBadElements(head2, 3);

        System.out.println("After Removing 3:");
        printList(head2);
    }
}