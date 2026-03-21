package _010_Linked_List._05_FAQ_Hard;

public class _05_Sort_LL {

    // Definition
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    // 🔍 Find middle of linked list
    public static ListNode findMiddle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // 🔀 Merge two sorted lists
    public static ListNode merge(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }

            temp = temp.next;
        }

        // Attach remaining nodes
        if (l1 != null) temp.next = l1;
        else temp.next = l2;

        return dummy.next;
    }

    // 🚀 Main Sort Function (Merge Sort)
    public static ListNode sortList(ListNode head) {

        // Base case
        if (head == null || head.next == null) {
            return head;
        }

        // Find middle
        ListNode mid = findMiddle(head);

        // Split list
        ListNode right = mid.next;
        mid.next = null;

        ListNode left = head;

        // Recursively sort both halves
        left = sortList(left);
        right = sortList(right);

        // Merge sorted halves
        return merge(left, right);
    }

    // 🖨️ Print
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // 🔥 Main
    public static void main(String[] args) {

        ListNode head = new ListNode(5);
        head.next = new ListNode(6);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        System.out.print("Original: ");
        printList(head);

        head = sortList(head);

        System.out.print("Sorted: ");
        printList(head);
    }
}