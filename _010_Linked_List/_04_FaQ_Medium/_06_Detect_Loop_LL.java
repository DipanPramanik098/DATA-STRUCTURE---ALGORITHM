package _010_Linked_List._04_FaQ_Medium;

public class _06_Detect_Loop_LL {

    // Definition of ListNode
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    // 🔍 Detect Loop
    public static boolean hasCycle(ListNode head) {

        // Edge case
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        // Traverse
        while (fast != null && fast.next != null) {

            slow = slow.next;           // move 1 step
            fast = fast.next.next;      // move 2 steps

            // If both meet → loop exists
            if (slow == fast) {
                return true;
            }
        }

        // No loop
        return false;
    }

    // 🚀 Main
    public static void main(String[] args) {

        // Create nodes
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);

        // Link nodes
        head.next = second;
        second.next = third;
        third.next = fourth;

        // Create loop: 4 → 2
        fourth.next = second;

        System.out.println("Loop Exists: " + hasCycle(head));
    }
}