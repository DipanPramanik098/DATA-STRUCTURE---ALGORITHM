package _010_Linked_List._04_FaQ_Medium;

public class _02_Middle_Of_LL {

    // Definition of ListNode
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // 🔍 Function to find middle
    public static ListNode findMiddle(ListNode head) {

        // Edge case
        if (head == null) return null;

        ListNode slow = head; // moves 1 step
        ListNode fast = head; // moves 2 steps

        // Traverse
        while (fast != null && fast.next != null) {
            slow = slow.next;          // +1 step
            fast = fast.next.next;     // +2 steps
        }

        // Slow will be at middle
        return slow;
    }

    // 🖨️ Print Linked List
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // 🚀 Main
    public static void main(String[] args) {

        // Create: 3 → 8 → 1 → 7 → 0
        ListNode head = new ListNode(3);
        head.next = new ListNode(8);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(0);

        System.out.print("List: ");
        printList(head);

        ListNode mid = findMiddle(head);

        System.out.println("Middle Node: " + mid.val);
    }
}