package _010_Linked_List._07_Contest;

// Definition for Singly Linked List
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class _03_specialLinkedList {

    // Function to partition the linked list
    public ListNode partitionList(ListNode head, int val) {

        // Dummy node for values smaller than val
        ListNode smallHead = new ListNode(-1);

        // Dummy node for values greater than or equal to val
        ListNode largeHead = new ListNode(-1);

        // Tail pointers for both lists
        ListNode small = smallHead;
        ListNode large = largeHead;

        // Traverse the original list
        ListNode temp = head;

        while (temp != null) {

            // If node value is smaller than val,
            // attach it to the small list
            if (temp.val < val) {
                small.next = temp;
                small = small.next;
            } else {
                // Otherwise attach it to the large list
                large.next = temp;
                large = large.next;
            }

            temp = temp.next;
        }

        // End the large list properly
        large.next = null;

        // Connect small list to large list
        small.next = largeHead.next;

        // Return the new head
        return smallHead.next;
    }

    // Helper function to insert at end
    public static ListNode insert(ListNode head, int val) {
        ListNode newNode = new ListNode(val);

        if (head == null) {
            return newNode;
        }

        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        return head;
    }

    // Function to print linked list
    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val);
            if (temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {

        _03_specialLinkedList obj = new _03_specialLinkedList();

        // Example 1
        ListNode head = null;
        head = insert(head, 5);
        head = insert(head, 2);
        head = insert(head, 4);
        head = insert(head, 1);
        head = insert(head, 3);
        head = insert(head, 4);

        System.out.println("Original List:");
        printList(head);

        int val = 3;
        head = obj.partitionList(head, val);

        System.out.println("After Partition around " + val + ":");
        printList(head);

        // Example 2
        ListNode head2 = null;
        head2 = insert(head2, 3);
        head2 = insert(head2, 7);
        head2 = insert(head2, 2);
        head2 = insert(head2, 5);
        head2 = insert(head2, 3);
        head2 = insert(head2, 1);

        System.out.println("\nOriginal List 2:");
        printList(head2);

        int val2 = 4;
        head2 = obj.partitionList(head2, val2);

        System.out.println("After Partition around " + val2 + ":");
        printList(head2);
    }
}