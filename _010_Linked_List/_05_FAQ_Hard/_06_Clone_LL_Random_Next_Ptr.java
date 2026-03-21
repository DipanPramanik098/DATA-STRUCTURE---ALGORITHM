package _010_Linked_List._05_FAQ_Hard;

public class _06_Clone_LL_Random_Next_Ptr {

    // Definition of special linked list node
    static class ListNode {
        int val;
        ListNode next;
        ListNode random;

        ListNode(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    // Step 1: Insert copied nodes after each original node
    public static void insertCopies(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            ListNode nextNode = temp.next;

            // create copied node
            ListNode copy = new ListNode(temp.val);

            // place copy just after original node
            temp.next = copy;
            copy.next = nextNode;

            // move to next original node
            temp = nextNode;
        }
    }

    // Step 2: Connect random pointers of copied nodes
    public static void connectRandomPointers(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            ListNode copyNode = temp.next;

            // if original random exists,
            // copied random = original random's copy
            if (temp.random != null) {
                copyNode.random = temp.random.next;
            } else {
                copyNode.random = null;
            }

            // move to next original node
            temp = copyNode.next;
        }
    }

    // Step 3: Separate original and copied lists
    public static ListNode separateCopiedList(ListNode head) {
        ListNode temp = head;

        // dummy head for copied list
        ListNode dummy = new ListNode(-1);
        ListNode copyTail = dummy;

        while (temp != null) {
            ListNode copyNode = temp.next;
            ListNode nextOriginal = copyNode.next;

            // add copied node to cloned list
            copyTail.next = copyNode;
            copyTail = copyNode;

            // restore original list
            temp.next = nextOriginal;

            // move to next original node
            temp = nextOriginal;
        }

        return dummy.next;
    }

    // Main function to clone linked list
    public static ListNode copyRandomList(ListNode head) {
        if (head == null) return null;

        // Step 1
        insertCopies(head);

        // Step 2
        connectRandomPointers(head);

        // Step 3
        return separateCopiedList(head);
    }

    // Print list with random pointers
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print("Node = " + head.val + ", Random = ");
            if (head.random != null) {
                System.out.print(head.random.val);
            } else {
                System.out.print("null");
            }
            System.out.println();
            head = head.next;
        }
    }

    public static void main(String[] args) {

        // Create original list: 1 -> 2 -> 3 -> 4
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        // Set random pointers
        head.random = head.next.next;              // 1 -> 3
        head.next.random = head;                   // 2 -> 1
        head.next.next.random = head.next.next.next; // 3 -> 4
        head.next.next.next.random = head.next;    // 4 -> 2

        System.out.println("Original List:");
        printList(head);

        ListNode clonedHead = copyRandomList(head);

        System.out.println("\nCloned List:");
        printList(clonedHead);
    }
}