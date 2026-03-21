package _010_Linked_List._03_Logic_Building;

public class _05_Reverse_LL {

    // Definition
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    // 🔁 Reverse Linked List (Iterative)
    public static ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {

            ListNode next = curr.next; // store next

            curr.next = prev;          // reverse link

            prev = curr;               // move prev
            curr = next;               // move curr
        }

        return prev; // new head
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

        head = reverse(head);

        System.out.print("Reversed: ");
        printList(head);
    }
}