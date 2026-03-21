package _010_Linked_List._03_Logic_Building;

public class _04_Remove_Nth_Node_From_Back {

    // Definition
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    // 🗑️ Remove Nth node from end
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Move fast n steps ahead
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // Step 2: If fast becomes null → delete head
        if (fast == null) {
            return head.next;
        }

        // Step 3: Move both pointers
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Step 4: Delete node
        slow.next = slow.next.next;

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

        head = removeNthFromEnd(head, 2);

        System.out.print("After Removal: ");
        printList(head);
    }
}