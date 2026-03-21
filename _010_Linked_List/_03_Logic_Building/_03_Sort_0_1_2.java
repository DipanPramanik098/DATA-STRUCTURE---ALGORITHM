package _010_Linked_List._03_Logic_Building;

public class _03_Sort_0_1_2 {

    // Definition
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    // 🔁 Sort 0s, 1s, 2s
    public static ListNode sortList(ListNode head) {

        // Edge case
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Dummy nodes
        ListNode zeroHead = new ListNode(-1);
        ListNode oneHead = new ListNode(-1);
        ListNode twoHead = new ListNode(-1);

        // Tail pointers
        ListNode zero = zeroHead;
        ListNode one = oneHead;
        ListNode two = twoHead;

        ListNode temp = head;

        // Step 2: Distribute nodes
        while (temp != null) {

            if (temp.val == 0) {
                zero.next = temp;
                zero = temp;
            }
            else if (temp.val == 1) {
                one.next = temp;
                one = temp;
            }
            else {
                two.next = temp;
                two = temp;
            }

            temp = temp.next;
        }

        // Step 3: Connect lists

        // Connect 0 → 1 or directly → 2
        zero.next = (oneHead.next != null) ? oneHead.next : twoHead.next;

        // Connect 1 → 2
        one.next = twoHead.next;

        // End last node
        two.next = null;

        // Step 4: Return new head
        return zeroHead.next;
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

        // Create: 1 → 0 → 2 → 0 → 1
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(0);
        head.next.next.next.next = new ListNode(1);

        System.out.print("Original: ");
        printList(head);

        head = sortList(head);

        System.out.print("Sorted: ");
        printList(head);
    }
}