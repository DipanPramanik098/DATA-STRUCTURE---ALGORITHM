package _010_Linked_List._04_FaQ_Medium;

public class _04_Check_Palindrome {

    // Definition
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    // 🔁 Reverse Linked List
    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next; // store next
            curr.next = prev;          // reverse
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // 🔍 Check Palindrome
    public static boolean isPalindrome(ListNode head) {

        // Edge case
        if (head == null || head.next == null) return true;

        // Step 1: Find middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;          // +1
            fast = fast.next.next;     // +2
        }

        // Step 2: Reverse second half
        ListNode secondHalf = reverse(slow.next);

        // Step 3: Compare
        ListNode first = head;
        ListNode second = secondHalf;

        while (second != null) {
            if (first.val != second.val) {
                reverse(secondHalf); // restore before return
                return false;
            }
            first = first.next;
            second = second.next;
        }

        // Step 4: Restore list
        reverse(secondHalf);

        return true;
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

        // Create: 3 → 7 → 5 → 7 → 3
        ListNode head = new ListNode(3);
        head.next = new ListNode(7);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(3);

        printList(head);

        System.out.println("Is Palindrome: " + isPalindrome(head));
    }
}