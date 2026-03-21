package _010_Linked_List._05_FAQ_Hard;

public class _01_Reverse_LL_in_Group_K {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    // 🔁 Reverse a linked list
    public static ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }

    // 🔍 Get Kth node from current position
    public static ListNode getKthNode(ListNode temp, int k) {

        while (temp != null && k > 1) {
            temp = temp.next;
            k--;
        }

        return temp;
    }

    // 🚀 Main Function
    public static ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp = head;
        ListNode prevLast = null;

        while (temp != null) {

            // Find kth node
            ListNode kthNode = getKthNode(temp, k);

            // If less than k nodes → stop
            if (kthNode == null) {
                if (prevLast != null) {
                    prevLast.next = temp;
                }
                break;
            }

            // Store next group start
            ListNode nextNode = kthNode.next;

            // Break list
            kthNode.next = null;

            // Reverse current group
            ListNode newHead = reverse(temp);

            // Update head
            if (temp == head) {
                head = newHead;
            } else {
                prevLast.next = newHead;
            }

            // Update prevLast (tail of reversed group)
            prevLast = temp;

            // Move to next group
            temp = nextNode;
        }

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

    // 🔥 Main
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Original: ");
        printList(head);

        head = reverseKGroup(head, 2);

        System.out.print("Result: ");
        printList(head);
    }
}