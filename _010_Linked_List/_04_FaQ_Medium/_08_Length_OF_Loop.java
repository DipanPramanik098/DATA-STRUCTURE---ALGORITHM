package _010_Linked_List._04_FaQ_Medium;

public class _08_Length_OF_Loop {

    // Definition
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    // 🔍 Find loop length
    public static int lengthOfLoop(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect loop
        while (fast != null && fast.next != null) {

            slow = slow.next;          // +1
            fast = fast.next.next;     // +2

            // Loop detected
            if (slow == fast) {

                // Step 2: Count loop length
                int count = 1;
                ListNode temp = slow.next;

                while (temp != slow) {
                    count++;
                    temp = temp.next;
                }

                return count;
            }
        }

        // No loop
        return 0;
    }

    // 🚀 Main
    public static void main(String[] args) {

        // Create nodes
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        // Connect
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        // Create loop: 5 → 2
        n5.next = n2;

        int len = lengthOfLoop(head);

        System.out.println("Loop Length: " + len);
    }
}