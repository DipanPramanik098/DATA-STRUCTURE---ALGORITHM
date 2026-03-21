package _010_Linked_List._03_Logic_Building;

public class _02_Segregate_ODD_EVEN {

    // Definition
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    // 🔁 Rearrange odd-even
    public static ListNode oddEvenList(ListNode head) {

        // Edge case
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Initialize pointers
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even; // store start of even list

        // Step 2: Rearrange
        while (even != null && even.next != null) {

            odd.next = odd.next.next;     // link next odd
            even.next = even.next.next;   // link next even

            odd = odd.next;               // move odd
            even = even.next;             // move even
        }

        // Step 3: Connect odd list with even list
        odd.next = evenHead;

        return head;
    }

    // 🖨️ Print
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // 🚀 Main
    public static void main(String[] args) {

        // Create: 1 → 2 → 3 → 4 → 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Original: ");
        printList(head);

        head = oddEvenList(head);

        System.out.print("Reordered: ");
        printList(head);
    }
}