package _010_Linked_List._04_FaQ_Medium;

public class _03_Delete_Middle {

    // Definition of ListNode
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // 🗑️ Delete Middle Node
    public static ListNode deleteMiddle(ListNode head) {

        // Edge Case: only one node
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head.next.next;

        // Move pointers
        while (fast != null && fast.next != null) {
            slow = slow.next;           // move 1 step
            fast = fast.next.next;      // move 2 steps
        }

        // Delete middle node
        slow.next = slow.next.next;

        return head;
    }

    // 🖨️ Print Linked List
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // 🚀 Main Method
    public static void main(String[] args) {

        // Create: 1 → 2 → 3 → 4 → 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Original: ");
        printList(head);

        head = deleteMiddle(head);

        System.out.print("After Deletion: ");
        printList(head);
    }
}