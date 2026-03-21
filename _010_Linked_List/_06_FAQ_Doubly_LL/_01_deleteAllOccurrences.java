package _010_Linked_List._06_FAQ_Doubly_LL;

// Node Definition
class ListNode {
    int val;
    ListNode next;
    ListNode prev;

    ListNode(int val) {
        this.val = val;
    }
}

public class _01_deleteAllOccurrences {

    // Function to delete all occurrences
    public ListNode deleteAllOccurrences(ListNode head, int target) {

        ListNode temp = head;

        while (temp != null) {

            if (temp.val == target) {

                ListNode nextNode = temp.next;
                ListNode prevNode = temp.prev;

                // If deleting head
                if (temp == head) {
                    head = nextNode;
                }

                // Connect prev -> next
                if (prevNode != null) {
                    prevNode.next = nextNode;
                }

                // Connect next -> prev
                if (nextNode != null) {
                    nextNode.prev = prevNode;
                }

                // Move forward
                temp = nextNode;
            } else {
                temp = temp.next;
            }
        }

        return head;
    }

    // Function to print DLL
    public static void printList(ListNode head) {
        ListNode temp = head;

        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        while (temp != null) {
            System.out.print(temp.val);
            if (temp.next != null) System.out.print(" <-> ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Helper to insert at end
    public static ListNode insert(ListNode head, int val) {
        ListNode newNode = new ListNode(val);

        if (head == null) return newNode;

        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;

        return head;
    }

    // MAIN METHOD
    public static void main(String[] args) {

        ListNode head = null;

        // Creating list: 1 <-> 2 <-> 3 <-> 1 <-> 4
        head = insert(head, 1);
        head = insert(head, 2);
        head = insert(head, 3);
        head = insert(head, 1);
        head = insert(head, 4);

        System.out.println("Original List:");
        printList(head);

        int target = 1;

        _01_deleteAllOccurrences obj = new _01_deleteAllOccurrences();
        head = obj.deleteAllOccurrences(head, target);

        System.out.println("After Deleting " + target + ":");
        printList(head);


        // Edge Case Test: All nodes same
        ListNode head2 = null;
        head2 = insert(head2, 7);
        head2 = insert(head2, 7);
        head2 = insert(head2, 7);

        System.out.println("\nOriginal List:");
        printList(head2);

        head2 = obj.deleteAllOccurrences(head2, 7);

        System.out.println("After Deleting 7:");
        printList(head2);
    }
}