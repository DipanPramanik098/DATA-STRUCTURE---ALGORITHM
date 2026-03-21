package _010_Linked_List._04_FaQ_Medium;

public class _07_Find_The_Starting_Point_Loop {

    // Definition
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    // 🔍 Find starting point of loop
    public static ListNode findStart(ListNode head) {

        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        // Phase 1: Detect loop
        while (fast != null && fast.next != null) {

            slow = slow.next;           // move 1 step
            fast = fast.next.next;      // move 2 steps

            // Loop detected
            if (slow == fast) {

                // Phase 2: Find starting node
                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow; // starting node
            }
        }

        // No loop
        return null;
    }

    // 🚀 Main
    public static void main(String[] args) {

        // Create nodes
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        // Connect nodes
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        // Create loop: 5 → 2
        n5.next = n2;

        ListNode start = findStart(head);

        if (start != null) {
            System.out.println("Loop starts at: " + start.val);
        } else {
            System.out.println("No Loop");
        }
    }
}